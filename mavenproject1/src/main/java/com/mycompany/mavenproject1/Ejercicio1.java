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
public class Ejercicio1 {
    
   public Double ss() {
    String datoLeido = entradaDeDatos(); //  "556.7"
    String datoLeido2 = entradaDeDatos();

		     
		Double HoradeTrabajo = Double.parseDouble( datoLeido );  // 556.7
                
                Double ValorDeHora = Double.parseDouble( datoLeido2 );  // 556.7
                Double resultado = ValorDeHora*HoradeTrabajo;  //   (Int)numeroConComa  =>  556
       
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
