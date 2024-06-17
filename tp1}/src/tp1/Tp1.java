/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1;

import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.IOException;

/**
 *
 * @author tafav
 */
public class Tp1 {

    
    
//    importante: a la hora de poner los valores de cada array, hagalos separandolos con un espacio, EJ: 1 2
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
           metodo m = new metodo();
                   metodo.metodo2 m2 = m.new metodo2();
        

int[] resultado = m.cargar();
int[] resultado2 = m2.cargar2();
        System.out.println(Arrays.toString(resultado));
        System.out.println(Arrays.toString(resultado2));

        int[] combinedArray = Arrays.copyOf(resultado, resultado.length + resultado2.length);
        System.arraycopy(resultado2, 0, combinedArray, resultado.length, resultado2.length);
        System.out.println(Arrays.toString(combinedArray));

        
        
        String joinedString = Arrays.toString(combinedArray);
        
        
        
        
        String archivo = "archivo_java.txt"; 


        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(archivo); 
            fos.write(joinedString.getBytes()); 
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
   
        

        
// Punto 2
StringBuilder resultados = new StringBuilder();
String archivo2 = "Resultados.txt";
String archivo3 = "error.txt";
FileOutputStream fos2 = null;
FileOutputStream fos3 = null;

try {
    fos2 = new FileOutputStream(archivo2);

    for (int i = 0; i < combinedArray.length - 1; i++) {
        int actual = combinedArray[i];
        int siguiente = combinedArray[i + 1] - 3;
        int resultadoe = 0;

        if (siguiente != 0) {
            resultadoe = actual / siguiente;
            String resultadoStr = "Resultado de dividir " + actual + " entre (" + combinedArray[i + 1] + " - 3): " + resultadoe + "\n";
            resultados.append(resultadoStr);
            System.out.println(resultadoStr);
                    
            if (siguiente < 0) {
            
            resultadoStr = "Error:" + actual + " entre (" + combinedArray[i + 1] + " - 3): " + resultadoe + "\n";
            resultados.append(resultadoStr);
            System.out.println(resultadoStr);
            fos3 = new FileOutputStream(archivo3);
             fos3.write(resultados.toString().getBytes());
            
        }
            
            
        } else {
            String errorStr = "División por cero detectada para el elemento " + actual + "\n";
            resultados.append(errorStr);
            System.out.println(errorStr);
        }
    }

    fos2.write(resultados.toString().getBytes());
    System.out.println("Resultados escritos correctamente en el archivo.");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fos2 != null) {
        try {
            fos2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
   }
}