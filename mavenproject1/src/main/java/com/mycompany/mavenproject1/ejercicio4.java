/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.IOException;

/**
 *
 * @author tafav
 */
public class ejercicio4 {
public Double ese() {
    String datoLeido =  entradaDeDatos(); //  "556.7"


		     
		Double valor = Double.parseDouble( datoLeido );  // 556.7
                
                
                Double resultado= (valor-32)* 0.5556; 

       
                return resultado;
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
