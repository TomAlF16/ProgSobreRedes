/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

//    Dado el precio de un artículo, la computadora muestra los valores a pagar según cada plan. 

import java.io.IOException;


//    Una casa de artículos para el hogar ofrece a sus clientes los siguientes planes de pago:
//Plan 1: 100% al contado. Se hace el 10% de descuento sobre el precio publicado.
//Plan 2: 50% al contado y el resto en 2 cuotas iguales. El precio publicado se incrementa en un 10%.
//Plan 3: 25% al contado y el resto en 5 cuotas iguales. El precio publicado se incrementa en un 15%.
//Plan 4: Totalmente financiado en 8 cuotas. El 60% se reparte en partes iguales 
//en las primeras 4 cuotas y el resto se reparte en partes iguales en las últimas 4 cuotas. 
//        El precio publicado se incrementa en un 25%
public class Ejercicio5 {

    
    public Double puto() {
System.out.println("Elija su plan");
String datoLeido =  entradaDeDatos();
System.out.println("Ingrese su precio");
String datoLeido2 =  entradaDeDatos();
Double Articulo = Double.parseDouble( datoLeido2 );




//Plan 1: 100% al contado. Se hace el 10% de descuento sobre el precio publicado.
Double Plan1 = Articulo / 10 *100;
//Plan 2: 50% al contado y el resto en 2 cuotas iguales. El precio publicado se incrementa en un 10%.
Double CalcularDescuento2 = Articulo / 10 *100;
Double CalcularDescuento2p2 = (CalcularDescuento2 +Articulo)/2;
Double Plan2 = CalcularDescuento2p2/2;
//Plan 3: 25% al contado y el resto en 5 cuotas iguales. El precio publicado se incrementa en un 15%.
Double CalcularDescuento3 = Articulo / 15 *100;
Double CalcularDescuento3p2 = (CalcularDescuento2 +Articulo)/5;
Double Plan3 = CalcularDescuento2p2/5;
//en las primeras 4 cuotas y el resto se reparte en partes iguales en las últimas 4 cuotas. <
        


if (datoLeido == "Plan 1") {
            System.out.println(Plan1);
        } else if (datoLeido == "Plan 2") {
            System.out.println(Plan2);
        } else {
            System.out.println(Plan3);
        }
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
