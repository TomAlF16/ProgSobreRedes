/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.PrintStream;
import java.io.IOException;

/**
 *
 * @author tafav
 */
public class EjercicioB2 {
    public Double putdo() {
    PrintStream ps = new PrintStream(System.out);
    String datoLeido =  entradaDeDatos();
    String datoLeido2 =  entradaDeDatos();
    String datoLeido3 =  entradaDeDatos();
    String datoLeido4 =  entradaDeDatos();
        Double Numero1 = Double.parseDouble( datoLeido );
        Double Numero2 = Double.parseDouble( datoLeido2 );
        Double Numero3 = Double.parseDouble( datoLeido3 );
        Double Numero4 = Double.parseDouble( datoLeido4);
        Double resultado = null;
   
        
        if (Numero1>Numero2 && Numero2>Numero3 && Numero3>Numero4  ) {
            resultado = Numero4;
}
        if (Numero2>Numero3 && Numero2>Numero4 && Numero3>Numero1  ) {
            resultado = Numero1;
        }
        
        if (Numero3>Numero4 && Numero4>Numero1 && Numero1>Numero2  ) {
            resultado = Numero2;
            }
        if (Numero4>Numero1 && Numero1>Numero2 && Numero2>Numero3  ) {
            resultado = Numero3;
            }

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
