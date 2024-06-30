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
public class EjercicioD2 {
        public int purfddo() {
    PrintStream ps = new PrintStream(System.out);
    
    String datoLeido =  entradaDeDatos();
    String datoLeido2 =  entradaDeDatos();
    int Numero1 = Integer.parseInt( datoLeido );
    int Numero2 = Integer.parseInt( datoLeido2 );
          
        int resultado= Numero1 % Numero2;
        if( Numero1 > Numero2){
            if( Numero1 % Numero2==0){
            ps.println("Es divisible");
            }else{ ps.println("no es divisible");}
            

        }else{   ps.println("No cumple condicion del ejercicio");

        }
        
        
        
        
        
            return 0;
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
