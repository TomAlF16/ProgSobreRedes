package Clase1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lectura {
	// Stream
	// Stream  IN
	// Stream  OUT
	// Stream  ERR
	
	PrintStream ps;
	
	
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
	
	public Lectura(){   
		//intermedio
		ps= new PrintStream( System.out);
		
		System.out.println("Byte:");
		//Scanner s = new Scanner(System.in);
		//System.err.println();
		
		
		
		System.out.write(  13  );  // 
		System.out.write(  10  );  // enter 
		System.out.write(  5 );
		System.out.write(  27 );
		
		
		//ASCII UNICODE 
		byte [] array = {78, 64, 119, 97, 19};
		try {
			System.out.write(array);
		} catch (IOException e) {
			Logger.getLogger( Clase1.Lectura.class.getName()).log(Level.SEVERE, null , e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		System.err.println("ERROR");
		System.out.flush();
		//System.out.println();
		
		ps.println("holaa");
		ps.printf("El numero elejido es: %d y su nombre: %s en su cuenta tiene; %.2f $ /n ",8,"PEPE",655.7);
	
File archivo = new File( "error.log" );
		
		//crea un canal de comunicacion de SALIDA,  destino: ARCHIVO(file)
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream( archivo, true );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		PrintStream error = new PrintStream( fos );
		System.setErr( error );

		
		System.err.println("esto es un error critico");
	
	}	
}