package tp1;

import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tafav
 */



//punto 1

public class metodo {

    public int[] cargar() {  
        String datosLeidos = entradaDeDatos();
        String[] valores = datosLeidos.split(" ");
        int[] s = new int[valores.length];

        for (int f = 0; f < valores.length; f++) {
            s[f] = Integer.parseInt(valores[f]);
        }	
        return s;   
    }
public class metodo2 {

        public int[] cargar2() {  
            String datosLeidos2 = entradaDeDatos();
            String[] valores2 = datosLeidos2.split(" ");
            int[] s = new int[valores2.length];

            for (int f = 0; f < valores2.length; f++) {
                s[f] = Integer.parseInt(valores2[f]);
            }	
            return s;
        
       
        
    }

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
