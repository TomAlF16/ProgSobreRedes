package javaapplication1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor extends Thread {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    PrintStream ps;
    static LinkedList<ClienteCli> ClientesConectados;

    ServerSocket serverSock;
    Socket sockCli;
    DataInputStream dis;
    DataOutputStream dos;
    int puerto = 7777;

    public Servidor() {
        try {
            ps = new PrintStream(System.out);
            dis = null;
            dos = null;
            ClientesConectados = new LinkedList<>();

            serverSock = new ServerSocket(puerto);

            // Verificación de clientes conectados
            Thread verificarLista = new Thread(() -> {
                while (true) {
                    synchronized (ClientesConectados) {
                        ClientesConectados.removeIf(cli -> !cli.getSock().isConnected() || !cli.isConected());
                    }
                    try {
                        Thread.sleep(10000); // Verificar cada 10 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            verificarLista.start(); // Inicia el hilo para verificar la lista de clientes conectados

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                ps.println("Esperando conexión de un cliente...\n");
                sockCli = serverSock.accept();

                ps.println(Servidor.ANSI_CYAN + "Cliente Conectado: " + sockCli.getInetAddress().getHostAddress()
                        + Servidor.ANSI_RESET);

                dis = new DataInputStream(sockCli.getInputStream());
                dos = new DataOutputStream(sockCli.getOutputStream());

                ps.println(Servidor.ANSI_CYAN + "Creando un cliente... esperando identificación..." + Servidor.ANSI_RESET);
                String nickName = dis.readUTF();

                ClienteCli cli = new ClienteCli(sockCli, nickName, dis, dos);
                synchronized (ClientesConectados) {
                    ClientesConectados.add(cli);
                }

                ps.println(Servidor.ANSI_RED + "El cliente " + (cli.getNickName() != null ? cli.getNickName() : "Desconocido") + " accedió al servidor.\n"
                        + Servidor.ANSI_RESET);
                if (cli.getHilo() != null && !cli.getHilo().isAlive()) {
                    cli.getHilo().start();
                }
                cli.notificarClientes(true);

            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
