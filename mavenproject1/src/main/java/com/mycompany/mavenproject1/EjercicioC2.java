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
public class EjercicioC2 {
        public int purdo() {
    PrintStream ps = new PrintStream(System.out);
    
    String datoLeido =  entradaDeDatos();
    int Numero1 = Integer.parseInt( datoLeido );
          
        int resultado= 0;
        if( Numero1 % 2 == 0){
        resultado=Numero1;
        ps.println(Numero1 + " Es par");
        }else{   
        resultado=Numero1;
        ps.println(Numero1 + " No es par");
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
