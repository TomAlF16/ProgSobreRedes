/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author tafav
 */
public class Ejercicio3a {
    
    
    
    
    
    static String Proceso() {
        String archivo = "datos_depisitados.txt";
 FileOutputStream fos = null;
 String datoLeido = entradaDeDatos();
 
  try {
            fos = new FileOutputStream(archivo); 
            fos.write(datoLeido.getBytes()); 
            System.out.println("Archivo creado y contenido escrito correctamente.");
        } catch (IOException e) {
            e.printStackTrace(); 
        } finally {
            if (fos != null) {
                try {
                    fos.close(); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    
     static  String entradaDeDatos() {
		
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


    

