package com.mycompany.mavenproject1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Guia {

    
	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
        String valores = null; 

 
	public static void main(String[] args) {
                 Ejercicio1 ejercicio1 = new Ejercicio1();
     Ejercicio2 ejercicio2 = new Ejercicio2();
     Ejercicio3 ejercicio3 = new Ejercicio3();
     ejercicio4 Ejercicio4 = new ejercicio4();
     Ejercicio6 Ejercicio6 = new Ejercicio6();
     Ejercicio7 Ejercicio7 = new Ejercicio7();
     
     EjercicioH2 EjercicioH2 = new EjercicioH2();
     EjercicioB2 EjercicioB2 = new EjercicioB2();
      EjercicioC2 EjercicioC2 = new EjercicioC2();
      EjercicioD2 EjercicioD2 = new EjercicioD2();
      EjercicioG2 EjercicioG2 = new EjercicioG2();
      EjercicioF2 EjercicioF2 = new EjercicioF2();
          Ejercicio3a ejercicio3a = new Ejercicio3a();
    
//
        Ejercicio3c Ejercicio3c = new Ejercicio3c();

		while (continuar) {
			ps.println("Ingrese la opción a ejecutar:?");
			ps.println("1- Ejercicio 1");
			ps.println("2- Ejercicio 2");
                        ps.println("3- Ejercicio 3");
			ps.println("4- Ejercicio 4");
                        ps.println("6- Ejercicio 6");
                        ps.println("7- Ejercicio 7");
                        ps.println("8- Ejercicio 2 B");
                        ps.println("9- Ejercicio 2 C");
                        ps.println("10- Ejercicio 2 D");
                        ps.println("11- Ejercicio 2 F");
                        ps.println("12- Ejercicio 2 G");
                        ps.println("13- Ejercicio 2 H");
                        ps.println("14- Ejercicio 3 A");
                        ps.println("No funciona en el codigo del menu por alguna razon" 
                                + "15- Ejercicio 3 C, D y E");
			ps.println("0- Salir");

			int opcion = Guia.leerOpcion();

			switch (opcion) {
			case 1:

				
                              System.out.println(ejercicio1.ss());  
                                
                                
                                
                                
				break;
			case 2:

                            
                            
                            
                            
                            System.out.println(ejercicio2.se());
                            
                            
				break;
			case 3:

                            System.out.println(ejercicio3.es());
                            
                            
                            
                            
                            
                            
				break;
                    case 4:

                            System.out.println(Ejercicio4.ese());
                            
                            
                            
                            
                            
                            
				break;
                                
                    case 5:

                            System.out.println(Ejercicio6.puto());
                            
                            
                            
                            
                            
                            
				break;
                    case 7:

                            System.out.println(Ejercicio7.wawa());
                            
                            
                            
                            
                            
                            
				break;
                    case 8:

                            System.out.println(EjercicioB2.putdo());
                            
                            
                            
                            
                            
                            
				break;
                    case 9:

                            
                            
                            
                          System.out.println(EjercicioC2.purdo());
                            
                            
                            
				break;
                    case 10:

                            
                            
                         System.out.println(EjercicioD2.purfddo());
                            
                              
                            
				break;
                    case 11:

                            
                            
                            System.out.println(EjercicioF2.LongApell());   
                         
                          
                            
                            
                            
				break;
                    case 12:

                            
                            
                            System.out.println(EjercicioG2.TablaNum());
                         
                            
                            
				break;
                    case 13:

                            
                            
                            System.out.println(EjercicioH2.Zn());
                         
                            
                            
				break;
                    case 14:

                            
                            
                            System.out.println(Ejercicio3a.Proceso());
                         
                            
                            
				break;
                    case 15:

                            
//                            Error acá por alguna razon:
//                            System.out.println(Ejercicio3c.imprimirNumerosPares());
                         
                            
                            
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


///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package com.mycompany.mavenproject1;
//import java.io.InputStreamReader;
//
//import java.io.PrintStream;
//
///**
// *
// * @author tafav
// */
//public class Guia {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        PrintStream ps = new PrintStream(System.out);
////        ps.println("Hola, mundo!");
////        ps.print(42);
////        ps.printf("El valor de PI es %.2f", Math.PI);

////   System.out.println(ejercicio1.ss());
////     System.out.println(ejercicio2.se());
////     System.out.println(ejercicio3.es());
////       System.out.println(Ejercicio4.ese());
////System.out.println(Ejercicio5.puto());
////System.out.println(Ejercicio6.wawa());
////System.out.println(EjercicioB2.putdo());
////System.out.println(EjercicioC2.purdo());
////System.out.println(EjercicioG2.TablaNum());
////System.out.println(EjercicioD2.purfddo());
////System.out.println(EjercicioF2.LongApell());
//
//
//
//
////int numero= 11;
////System.out.println(numero/numero);
//
//
//
//
//    }
//
//}

      