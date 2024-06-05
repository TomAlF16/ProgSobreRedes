package trabajoPractico2Archivos;

import java.io.IOException;

public class Menu {

	public Double menu() {
		System.out.println("1-ingresar Producto"
				+ "2-salir"
				+ "3-Mostrar Producto");
		
		
		return null;

	     
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