package Deportes;
import java.util.Random;

public class Atleta extends Thread {
    
    private int fuerza; //remar
    private int velocidad;
    private int natacion;
    private int velocidadBici;
    private Equipo equipo;
    private boolean posta;
   String nombre;

    // Constructor para inicializar los atributos con va0lores aleatorios
    public Atleta(String nombre1, Equipo equipo1) {
    this.nombre = nombre1;
    this.equipo = equipo1;  // Corrección
    Random rand = new Random();
    this.fuerza = rand.nextInt(2701) + 300;
    this.velocidad = rand.nextInt(2701) + 300;
    this.natacion = rand.nextInt(2701) + 300;
    this.velocidadBici = rand.nextInt(2701) + 300;
    this.posta = false;
}

    public Equipo getEquipo() {
        return equipo;
    }

    public boolean isPosta() {
        return posta;
    }


    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setNatacion(int natacion) {
        this.natacion = natacion;
    }

    public void setVelocidadBici(int rvelocidadBici) {
        this.velocidadBici = velocidadBici;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setPosta(boolean posta) {
        this.posta = posta;
    }

    // Getters
    public int getFuerza() {
        return fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getNatacion() {
        return natacion;
    }

    public int getVelocidadBici() {
        return velocidadBici;
    }

    public boolean Posta() {
        return posta;
    }

    // Método para recibir la posta
    public void recibirPosta() {
        this.posta = true;
    }

    
public int ChangeActivity(String Actividad) {
    
    if (Actividad.equals("remo")) {
        return fuerza;  //remo
    } else if (Actividad.equals("nadar")) {
        return natacion;
    } else if (Actividad.equals("correr")) {
        return velocidad;
    } else if (Actividad.equals("bici")) {
        return velocidadBici;
    } else {
        return 0;
    }
}
    
    public void run(){
    try{
        synchronized(equipo){
        while(!posta){
        
        equipo.wait();
        
        }
        }
        
        String Activity =equipo.getActividad();
        int TimeR= ChangeActivity(Activity);
        String TeamName= equipo.getNombreEquipo();
        
        System.out.println(" el jugador " + nombre + " del equipo " + TeamName +"Empieza con la actividad "+ Activity +" en" + TimeR  );
        Thread.sleep(TimeR);
        equipo.agregarTiempo(TimeR);
        synchronized (equipo) {
					equipo.cambiarPosta();
					equipo.notifyAll();
				}
    
    
    }catch(InterruptedException e) {
				e.printStackTrace();
			}
    
    
    }
    
    
    // Método run (simula la carrera del atleta)
    
   


}