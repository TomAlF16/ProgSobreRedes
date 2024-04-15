/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author tafav
 */


//Consigna:
//Dada la superficie de un cuadrado (en m2), la computadora muestra su perímetro.


public class Ejercicio3 {
    public Double es() {
    String datoLeido =  entradaDeDatos(); //  "556.7"


		     
		Double valor = Double.parseDouble( datoLeido );  // 556.7
                
                
                Double resultado= Math.sqrt(valor); 

       
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
