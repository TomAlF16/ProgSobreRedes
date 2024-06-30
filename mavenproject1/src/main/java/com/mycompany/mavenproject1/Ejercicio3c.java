/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3c {

    public void imprimirNumerosPares() {
        String archivo = "Numeros.txt";
        
        String NumCadena= null;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= 1000) {
            
            
//            Ejercicio E
            
            if (i % 3 == 0) {
                System.out.println(0);
            }
            
            
            
            if (i % 2 == 0) {
                
                 
//                Ejercicio D :
                NumCadena= Integer.toString(i);
                
            }
            i++;
            
            sb.append(NumCadena).append(System.lineSeparator()); // Agrega el número par al StringBuilder y añade un salto de línea
        }
              
        
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                   
            writer.write(sb.toString());
//            System.out.println("Archivo creado y contenido escrito correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    

}
    
}
 