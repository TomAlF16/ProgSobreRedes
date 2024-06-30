/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tafav
 */
public class Ejercicio2 {
//    Dados los valores de dos de los 
//    ángulos interiores de un triángulo, la computadora muestra el valor del restante.

    
//    
//    float angulo1= 2;
//    float angulo2= 2;
//    float angulo3= 180-(angulo1 + angulo2);
//     public float obtenerResultado() {
//        return angulo3;


    
   public Double se() {
    String datoLeido =  entradaDeDatos(); //  "556.7"
    String datoLeido2 = entradaDeDatos();

		     
		Double angulo1 = Double.parseDouble( datoLeido );  // 556.7
                
                Double angulo2 = Double.parseDouble( datoLeido2 );  // 556.7
                Double resultado = 180-(angulo1 + angulo2);  //   (Int)numeroConComa  =>  556
       
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






