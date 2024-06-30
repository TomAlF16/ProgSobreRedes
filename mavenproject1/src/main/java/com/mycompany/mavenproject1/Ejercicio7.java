/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.classfile.ClassReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tafav
 */
public class Ejercicio7 {
    	PrintStream ps;
	InputStreamReader isr;
	BufferedReader br;
	
	public String wawa()
	{
		isr = new InputStreamReader( System.in );
		br = new BufferedReader( isr );
		
		ps = new PrintStream( System.out );
                
                
                
                
                
                String datoLeido =  leer();
                
                 if (datoLeido.equals("Capricornio")) {
        System.out.println("Enero");
    } else if (datoLeido.equals(datoLeido.equals("Acuario"))) {
        System.out.println("Febrero");
    } else if (datoLeido.equals(datoLeido.equals("Piscis"))) {
        System.out.println("Marzo");
    } else if (datoLeido.equals(datoLeido.equals("Aries"))) {
        System.out.println("Abril");
        } else if (datoLeido.equals(datoLeido.equals("Tauro"))) {
        System.out.println("Mayo");
        } else if (datoLeido.equals(datoLeido.equals("Géminis"))) {
        System.out.println("Junio");
        } else if (datoLeido.equals(datoLeido.equals("Cáncer"))) {
        System.out.println("Julio");
        
    
    
    } else {
        System.out.println("Nada");
    }
    return null;
                
                
                
                             
	}
	
	public String leer()
	{
		try {
			
			return br.readLine();	
		} catch (IOException e) {
			Logger.getLogger( ClassReader.class.getName() ).log(Level.WARNING , null , e ) ;
		}
		
		return null;
	}
	
}

        

        
        





