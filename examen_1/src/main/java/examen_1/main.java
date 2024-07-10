package examen_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {
	
	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
	String valores = null;

	public static void main(String[] args) {
		String valores = null;
		while (continuar) {
			ps.println("Ingrese la opción a ejecutar:?");
			ps.println("1- Jugar");
			ps.println("2- Mostrar" + " ");

			ps.println("0- Salir");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
				// El jugador ingresa una letra
				ps.println("Ingrese una Letra");
				String Valor5 = entradaDeDatos().toUpperCase();
				String Letra = Valor5;

				ps.println("Ingrese un color que empiece con la letra " + Letra);
				// Se ingresa la primer palabra
				String Valor1 = entradaDeDatos().toUpperCase();
				String color = Valor1;
				ps.println("Ingrese un animal que empiece con la letra " + Letra);
				// Se ingresa la segunda palabra
				String Valor2 = entradaDeDatos().toUpperCase();
				String animal = Valor2;
				ps.println("Ingrese un objeto que empiece con la letra " + Letra);
				// Se ingresa la segunda palabra
				String Valor3 = entradaDeDatos().toUpperCase();
				String objetos = Valor3;
				ps.println("Ingrese un Alimento que empiece con la letra " + Letra);
				String Valor4 = entradaDeDatos().toUpperCase();
				String alimento = Valor4;

				String archivo = "tuti-fruti.csv";
				FileOutputStream fos = null;
				 valores = color + ";" + animal + ";" + objetos + ";" + alimento;
				// El programa Verifica que las palabras efectivamente empiecen con la letra
				boolean Correcto = false;
				
				if (Valor1.startsWith(Letra.toUpperCase())) {
					if (Valor2.startsWith(Letra)) {
						if (Valor3.startsWith(Letra)) {
							if (Valor4.startsWith(Letra)) {
								Correcto = true;
							}
						}
					}
				}

				if (Correcto == true) {
					try {
						fos = new FileOutputStream(archivo,true);
						
						fos.write(valores.getBytes());
						fos.write('\n');
						
						System.out.println("Añadido Exitosamente");
						
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
					
				}
				else {
					System.out.println("Error");
				}

				break;
			case 2:
				System.out.println(valores);
				break;

			case 0:
				ps.println("Saliendo del menú...");
				continuar = false;
				break;
			default:
				ps.println("Opción inválida. Por favor, ingrese una opción válida.");
				break;
			}
		}
	}

	static int leerOpcion() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opcion = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			ps.println("Ingrese la opción:");
			try {
				String input = reader.readLine();
				opcion = Integer.parseInt(input);

				if (opcion >= 0) {
					entradaValida = true;
				} else {
					ps.println("Error: Por favor, ingrese un número entero positivo.");
				}
			} catch (NumberFormatException | IOException e) {
				ps.println("Error: Por favor, ingrese un número entero válido.");
			}
		}

		return opcion;
	}

	static String Proceso() {

		return null;
	}

	static String entradaDeDatos() {

		String cadena = "";
		try {
			int Byte = -1;
			while ((Byte = System.in.read()) != '\n') {
				if (Byte != 13)
					cadena += (char) Byte;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return cadena;
	}

	int IntString(String texto) {

		int nose = Integer.parseInt(texto);
		return nose;

		// Float.parseFloat(texto);

	}

	float FloatString(String texto) {

		float val = Float.parseFloat(texto);

		return val;

	}

}