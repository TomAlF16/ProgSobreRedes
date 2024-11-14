/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Deportes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tafav
 */
public class readers {
    
	PrintStream ps;
	InputStreamReader isr;
	BufferedReader br;
	
	public readers()
	{
		isr = new InputStreamReader( System.in );
		br = new BufferedReader( isr );
		
		ps = new PrintStream( System.out );
	}
	
	public String leer()
	{
		try {
			
			return br.readLine();	
		} catch (IOException e) {
			Logger.getLogger( readers.class.getName() ).log(Level.WARNING , null , e ) ;
		}
		
		return null;
	}
}
