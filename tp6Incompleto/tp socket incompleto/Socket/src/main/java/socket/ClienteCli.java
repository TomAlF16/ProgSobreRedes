package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

public class ClienteCli implements Runnable {

    String nickName = "";
    Socket sock;
    Thread hilo;

    final DataInputStream disCliente;
    final DataOutputStream dosCliente;
    boolean isConected;
    PrintStream ps;

    private boolean baneado = false;
    private long tiempoBan = 0;
    private long tiempoInicioBan = 0;

    private static final List<String> MALAS_PALABRAS = new ArrayList<>();
    static {
        MALAS_PALABRAS.add("joder");
        MALAS_PALABRAS.add("mierda");
        MALAS_PALABRAS.add("puta");
        MALAS_PALABRAS.add("puto");
        MALAS_PALABRAS.add("pija");
    }

    public ClienteCli(Socket sock, String nick, DataInputStream in, DataOutputStream out) {
        this.nickName = nick;
        this.sock = sock;
        this.disCliente = in;
        this.dosCliente = out;

        ps = new PrintStream(System.out);
        this.isConected = true;
        this.hilo = new Thread(this, nickName);
    }

    @Override
    public void run() {
        String msgRecibido = "";
        String destino = "";

        while (this.sock.isConnected() && this.isConected) {
            try {
                if (baneado && System.currentTimeMillis() > tiempoInicioBan + tiempoBan) {
                    baneado = false;
                    tiempoBan = 0;
                    dosCliente.writeUTF(Servidor.ANSI_GREEN + "Tu baneo ha expirado. Ya puedes enviar mensajes." + Servidor.ANSI_RESET);
                }

                msgRecibido = this.disCliente.readUTF().trim();

                if (baneado) {
                    dosCliente.writeUTF(Servidor.ANSI_RED + "Estás baneado y no puedes enviar mensajes." + Servidor.ANSI_RESET);
                    continue;
                }

                msgRecibido = filtrarMalasPalabras(msgRecibido);

                if (msgRecibido.startsWith("/ban")) {
                    StringTokenizer token = new StringTokenizer(msgRecibido);
                    token.nextToken();
                    if (token.countTokens() == 2) {
                        String usuarioBanear = token.nextToken().trim();
                        long tiempoBaneo = Long.parseLong(token.nextToken().trim());
                        for (ClienteCli cli : Servidor.ClientesConectados) {
                            if (cli.getNickName().equalsIgnoreCase(usuarioBanear)) {
                                cli.banear(tiempoBaneo);
                                dosCliente.writeUTF(Servidor.ANSI_RED + "El usuario " + usuarioBanear + " ha sido baneado por " + tiempoBaneo + " segundos." + Servidor.ANSI_RESET);
                                break;
                            }
                        }
                    } else {
                        dosCliente.writeUTF(Servidor.ANSI_RED + "Uso incorrecto del comando. Formato: /ban <usuario> <tiempo_en_segundos>" + Servidor.ANSI_RESET);
                    }
                    continue;
                }

                if (msgRecibido.startsWith("/list")) {
                    StringBuilder clientes = new StringBuilder("Clientes conectados:\n");
                    synchronized (Servidor.ClientesConectados) {
                        for (ClienteCli cli : Servidor.ClientesConectados) {
                            clientes.append(cli.getNickName()).append("\n");
                        }
                    }
                    dosCliente.writeUTF(Servidor.ANSI_GREEN + clientes.toString() + Servidor.ANSI_RESET);
                    continue;
                }

                if (msgRecibido.contains("#")) {
                    StringTokenizer token = new StringTokenizer(msgRecibido, "#");
                    destino = token.nextToken().trim().toLowerCase();
                    msgRecibido = token.nextToken().trim();
                } else {
                    destino = "";
                }

                ps.println("\n" + Servidor.ANSI_PURPLE + "El cliente " + Servidor.ANSI_GREEN + this.nickName
                        + Servidor.ANSI_PURPLE + " envía: " + Servidor.ANSI_YELLOW + msgRecibido + "\n\t"
                        + Servidor.ANSI_PURPLE + " al cliente =>" + Servidor.ANSI_CYAN
                        + (destino.equalsIgnoreCase("") ? " Todos" : " ".concat(destino.toUpperCase())) + "\n"
                        + Servidor.ANSI_RESET);

                synchronized (Servidor.ClientesConectados) {
                    boolean clienteDisponible = false;
                    for (ClienteCli cli : Servidor.ClientesConectados) {
                        if (cli.getNickName().toLowerCase().equalsIgnoreCase(destino) && this.isConected) {
                            clienteDisponible = true;
                            cli.dosCliente.writeUTF(Servidor.ANSI_BLUE + "MP de " + this.nickName + ": " + Servidor.ANSI_RESET + msgRecibido);
                            break;
                        }
                    }
                    if (!clienteDisponible && !destino.equalsIgnoreCase("")) {
                        dosCliente.writeUTF(Servidor.ANSI_RED + "Cliente no disponible." + Servidor.ANSI_RESET);
                    } else if (destino.equalsIgnoreCase("")) {
                        for (ClienteCli cli : Servidor.ClientesConectados) {
                            if (!cli.getNickName().equalsIgnoreCase(this.nickName) && this.isConected) {
                                cli.dosCliente.writeUTF(Servidor.ANSI_YELLOW + "Global de " + this.nickName + ": " + Servidor.ANSI_RESET + msgRecibido);
                            }
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(ClienteCli.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }

        notificarClientes(false);

        this.isConected = false;
        synchronized (Servidor.ClientesConectados) {
            Servidor.ClientesConectados.remove(this);
        }
    }

    private String filtrarMalasPalabras(String msg) {
        for (String malaPalabra : MALAS_PALABRAS) {
            msg = msg.replaceAll("(?i)" + malaPalabra, "****");
        }
        return msg;
    }

    void notificarClientes(boolean nuevo) {
        String mensaje = nuevo ? " se ha conectado." : " se ha desconectado.";
        synchronized (Servidor.ClientesConectados) {
            for (ClienteCli cli : Servidor.ClientesConectados) {
                try {
                    cli.dosCliente.writeUTF(Servidor.ANSI_YELLOW + "El cliente " + this.nickName + mensaje + Servidor.ANSI_RESET);
                } catch (IOException ex) {
                    Logger.getLogger(ClienteCli.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void banear(long tiempoSegundos) {
        this.baneado = true;
        this.tiempoBan = tiempoSegundos * 1000;
        this.tiempoInicioBan = System.currentTimeMillis();
    }

    public boolean isConected() {
        return isConected;
    }

    public String getNickName() {
        return nickName;
    }

    public Thread getHilo() {
        return hilo;
    }

    public Socket getSock() {
        return sock;
    }
}
