package trabajoPractico2Archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);

	
	static void menu() {
		while (continuar) {
			ps.println("Ingrese la opción a ejecutar:");
			ps.println("1- Agregar un Producto");
			ps.println("2- Mostrar"
					+ " ");

			ps.println("0- Salir");

			int opcion = Main.leerOpcion();

			switch (opcion) {
			case 1:
				
				ps.println("Ingrese nombre de el producto: ");
				
				break;
			case 2:
				ps.println("");
				// Lógica 
				break;
			case 3:
				ps.println("");
				// Lógica
				break;
			case 0:
				ps.println("Saliendo del menú...");
				continuar = false;
				break;
			default:
				ps.println("Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}
		}
	}

    static int leerOpcion() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            ps.println("Ingrese la opción:");
            try {
                String input = reader.readLine(); 
                opcion = Integer.parseInt(input); 

                
                if (opcion >= 0) {
                    entradaValida = true; 
                } else {
                    ps.println("Error: Por favor, ingrese un número entero positivo.");
                }
            } catch (NumberFormatException | IOException e) {
                ps.println("Error: Por favor, ingrese un número entero válido.");
            }
        }

        return opcion;
    }
    
    
    
    public String entradaDeDatos() {
		
		String cadena = "";
		try {
			int Byte = -1;
			while(    (Byte = System.in.read())  != '\n'    ) 
			{
				if( Byte != 13 )
					cadena += (char)Byte;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cadena;
	}
    
     int IntString(String texto) {
    	 
        int nose= Integer.parseInt(texto);
		return nose; 

       
    //   Float.parseFloat(texto);
    	
    }
     
     float FloatString(String texto) {
    	 
    	 float val = Float.parseFloat(texto);
        
 		return val ; 

        
      
     	
     }
    
    
    
    
    
    

}
