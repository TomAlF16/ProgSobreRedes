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
public class EjercicioF2 {
    
    PrintStream ps = new PrintStream(System.out);
    
    public int LongApell() {
    String apellido =  entradaDeDatos();
    String apellido2 =  entradaDeDatos();
    int LongApellido1= apellido.length();
    int LongApellido2= apellido2.length();
    
    
      if(LongApellido1>LongApellido2){
      ps.println(apellido+ " Es más largo que "+ apellido2) ;
      }else{ps.println(apellido2+ " Es más largo que "+ apellido); }
      
      
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
