/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author tafav
 */
public class EjercicioG2 {
    
         int TablaNum() {
    	 String datoLeido =  entradaDeDatos();
         int Numero = Integer.parseInt( datoLeido );
         PrintStream ps = new PrintStream(System.out);
         ps.println("la tabla de " + Numero+ ":");
         ps.println(Numero+"x1:"+" "+ Numero*1);
         ps.println(Numero+"x2:"+" "+ Numero*2);
         ps.println(Numero+"x3:"+" "+ Numero*3);
    	 ps.println(Numero+"x4:"+" "+ Numero*4);
        ps.println(Numero+"x5:"+" "+ Numero*5);
        ps.println(Numero+"x6:"+" "+ Numero*6);
        ps.println(Numero+"x7:"+" "+ Numero*7);
        ps.println(Numero+"x8:"+" "+ Numero*8);
        ps.println(Numero+"x9:"+" "+ Numero*9);
        ps.println(Numero+"x10:"+" "+ Numero*10);
 		return 0 ; 

        
      
     	
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
}
