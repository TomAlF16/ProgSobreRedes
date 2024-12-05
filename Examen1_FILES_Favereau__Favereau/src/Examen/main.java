package Examen;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class main {
	
	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
	static  String valores = null; 
    static  String archivo = "datos.csv";
 
	public static void main(String[] args) {
		String Producto = null;
		String marca =null;
		String cantidad =null;
		String precio =null;
		archivo = "datos.csv";
		
		String valores1 = Producto + ";" + precio+";"+cantidad +";"+ marca  ;
		while (continuar) {
			System.out.println("Ingrese la opción a ejecutar:?");
			System.out.println("1- Agregar un Producto");
			System.out.println("2- Mostrar"
					+ " ");

			System.out.println("0- Salir");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
				
				ps.println("Ingrese nombre de el producto: ");
                                 Producto = entradaDeDatos();
                                ps.println("Ingrese el precio: ");
                                precio = entradaDeDatos();
                                ps.println("Ingrese el stock: ");
                                cantidad = entradaDeDatos();
                                ps.println("Ingrese la marca: ");
                                marca = entradaDeDatos();
                                

                                        String archivo = "datos.csv";
                                 FileOutputStream fos = null;
                                 String valores = Producto + ";" + precio+";"+cantidad +";"+ marca  ;

                                 
                                 try {
                               	        
                                           fos = new FileOutputStream(archivo,true);
                                           ps = new PrintStream(fos, true);
                                           ps.write(valores.getBytes() );
                                           
                                           /// 1ps.println( '\n' );
                                          

                                         
                                           
                                       } catch (IOException e) {
                                           e.printStackTrace(); 
                                       } 
                                           
                                 System.out.println("Producto añadido al inventario");

                                  
				break;
			case 2:
				
				try {
					LeerFileConBuffer("datos.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				break;
				
			case 3:

				
				
				
				
				
				
				

				
				
				
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
    
    
    static String Proceso() {


        return null;
    }
    
    
    
    static String entradaDeDatos() {
		
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
    
    
    
    static int IntString(String texto) {
    	 
        int nose= Integer.parseInt(texto);
		return nose; 

       
    //   Float.parseFloat(texto);
    	
    }
     
     
    static float FloatString(String texto) {
    	 
    	 float val = Float.parseFloat(texto);
        
 		return val ; 

        
      
     	
     }
    
    
    static public   void LeerFileConBuffer(String arch) throws FileNotFoundException, IOException {
         FileReader fr = new FileReader(arch);
         BufferedReader br = new BufferedReader(fr);

         String linea = "", texto = "";
         while ((linea = br.readLine()) != null) {
             texto += "\n" + linea;
         }
         System.out.println(texto);
         br.close();
         fr.close();

         
     }
    
    
    static public   void Editar(String arch) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(arch);
        BufferedReader br = new BufferedReader(fr);

        String linea = "", texto = "";
        while ((linea = br.readLine()) != null) {
            texto += "\n" + linea;
        }
        System.out.println(texto);
        br.close();
        fr.close();
    
        ////// guardar todo en un array list
////////un for en el array list
/////// si el nombre es igual, hace un split y luego toma el stock

//////traduce el stock a int y los 
		ArrayList<String> productos = new ArrayList<>();
		productos.add(valores);
        for (int i = 0; i <= productos.size(); i++) {
        	
      	String nose = productos.get(i);
      	String[] Stock= nose.split(";",2);
        ////es
      	
      	
        
          
        	
   //     }
		
    
    

    

}
    }
}



