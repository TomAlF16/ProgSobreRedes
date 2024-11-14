package Deportes;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("Carrera de Postas");
    public static void main(String[] args) throws IOException {
        
    

        PrintStream print = new PrintStream(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Equipo> equipos = new ArrayList<>();
        List<String> ganador = new ArrayList<>(); 
        float tiempoInicio = System.currentTimeMillis();
        
        
            for(int i = 1; i <= 4; i++) {
                print.printf("Crea el " + i + "* Equipo:\n");
                Equipo equipo = new Equipo("Equipo " + i); // Llama al constructor con un solo parámetro
                equipo.setGanadores((ArrayList<String>) ganador);
                
                for (int j = 1; j <= 4; j++) {
                    print.printf("Ingresando el " + j + "* atleta del " + i + "* equipo:\n");
                    print.print("Nombre del atleta: ");
                    
                    // Leer el nombre del atleta
     
                    String nombre = reader.readLine();
                    
                    // Crear el atleta y agregarlo al equipo
                    Atleta atleta = new Atleta(nombre, equipo);
                    equipo.AñadirAtleta(atleta);
                }
                
                // Agregar el equipo a la lista de equipos
                equipos.add(equipo);
            }
            System.out.println("¡La carrera ha comenzado!");
        for (Equipo equipo : equipos) {
            equipo.ComenzarCarrera();
        }
        
        for (Equipo equipo : equipos) {
            for (Atleta atleta : equipo.getEquipo()) {
                try {
                    atleta.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
          //  ganadores.add(equipo.getNombre());
        }
         float  duracion = 0;

        for (Equipo equipo : equipos) {
            float tiempoEquipo = equipo.getTiempo();
            if (tiempoEquipo > duracion) {
                duracion = tiempoEquipo; 
            }
        }
        float minutos = (duracion / 1000) / 60;
        float segundos = (duracion / 1000) % 60;

        System.out.printf("La carrera ha terminado en %2f minutos y %2f segundos.\n", minutos, segundos);
       
        logger.info("Mostrando el equipo ganador y tiempos de cada equipo:");
        for (int i = 0; i < ganador.size(); i++) {
            String nombreEquipo = ganador.get(i);
            for (Equipo equipo : equipos) {
                if (equipo.getNombreEquipo().equals(nombreEquipo)) {
                    int tiempoEquipoT = equipo.getTiempo();
                    float minT = (tiempoEquipoT / 1000) / 60;
                    float segT = (tiempoEquipoT / 1000) % 60;
                    float milisegundos = tiempoEquipoT % 1000;
        System.out.printf("Posición %d: %s — %.2f min %.2f seg %.2f ms\n", 
                i + 1, nombreEquipo, minT, segT, milisegundos);
                    break; // salimos del bucle cuando encuentro el equipo
        
        
        
        
        } 
    }
}
        }
    }