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
public class EjercicioH2 {
    	PrintStream ps;
	InputStreamReader isr;
	BufferedReader br;
	
	public String Zn()
	{
		isr = new InputStreamReader( System.in );
		br = new BufferedReader( isr );
		
		ps = new PrintStream( System.out );
                
                
                
                
                
String datoLeido = leer();
Double Numero = Double.parseDouble(datoLeido);
int contador = 0;

for (int i = 2; i <= Numero / 2; i++) {
    if (Numero % i == 0) {
        contador++;
        break;
    }
}

if (contador == 0 && Numero > 1) {
    System.out.println(Numero + " es primo");
} else {
    System.out.println(Numero + " no es primo");
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

        

        
        





