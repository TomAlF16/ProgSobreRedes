
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

	private static final boolean VerdaderoFalso = false;
	////// Cosas por hacer
	/// modificar el mostrador para que haga una separacion por marca
	/// que se pueda vender un producto

	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
	String valores = null;
	String valores1 = valores;
	String archivo = "inventario.csv";
	File archivoe = new File(archivo);

	public static void main(String[] args) {
		String Producto = null;
		String precio = null;
		String cantidad = null;

		//// valores añadidos:
		String categoria = null;
		String fecha = null;
		String marca = null;

		String archivo = "inventario.csv";
		File archivoe = new File(archivo);

		// ( nombre;marca;categoria;cantidad;precio;fecha )

		while (continuar) {
			ps.println("Ingrese la opción a ejecutar:?");
			ps.println("1- Agregar un Producto");
			ps.println("2- Mostrar" + " ");
			ps.println("3- Comprar" + " ");
			ps.println("4- Buscar por marca" + " ");
			ps.println("5- vender" + " ");
			ps.println("0- Salir");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:

				ps.println("Ingrese nombre: ");
				Producto = entradaDeDatos();
				ps.println("Ingrese la marca del producto: ");
				marca = entradaDeDatos();
				ps.println("Ingrese la marca de la categoria: ");
				categoria = entradaDeDatos();

				ps.println("Ingrese el stock: ");
				cantidad = ValidacionInt();
				ps.println("Ingrese el precio: ");
				precio = ValidacionInt();
				ps.println("Ingrese la fecha: ");
				fecha = entradaDeDatos();

				FileOutputStream fos = null;
				String valores = Producto + ";" + marca + ";" + categoria + ";" + cantidad + ";" + precio + ";" + fecha
						+  ";" +"\n"

				;

				try {
					fos = new FileOutputStream(archivo, true);
					fos.write(valores.getBytes());
					System.out.println("Producto añadido al inventario");
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

				break;
			case 2:

				try {
					LeerFileConBuffer("inventario.csv");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:
				Comprar(archivoe);
				break;
			case 4:
				try {
					BuscarXmarca("inventario.csv");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				Vender(archivoe);
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

	public File getArchivo() {
		return this.archivoe;
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
	
	
	static String ValidacionInt() {
        Boolean VerdaderFalso= false;
		String cadena = entradaDeDatos();
		
		
		
	    while (!cadena.matches("\\d+")) { 
	        System.out.println("Por favor, ingrese solo números enteros.");
	        cadena = entradaDeDatos();
			}

		return cadena;
	}
	
	
	
	
	
	
	
	
	
	

	static public void LeerFileConBuffer(String arch) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(arch);
		BufferedReader br = new BufferedReader(fr);

		String linea = "", texto = "";
		while ((linea = br.readLine()) != null) {
			texto += "\n" + linea;
		}
		System.out.println(texto.replace(";", " "));
		br.close();
		fr.close();
	}

	static public void BuscarXmarca(String arch) throws FileNotFoundException, IOException {
		System.out.println("¿Que Marca esta usted buscando?");
		ArrayList<String> listado = new ArrayList<>();
		String MarcaBuscada = entradaDeDatos();
		FileReader fr = new FileReader(arch);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		
		while ((linea = br.readLine()) != null) {
			boolean agregar = true;
			String[] partes = linea.split(";");
			if (partes.length > 1 && partes[1].equalsIgnoreCase(MarcaBuscada)) {
				//System.out.println("entre");
				
				for (int l = 0; l < listado.size(); l++) {
					String pedazo = listado.get(l);
					String[] divIdk = pedazo.split(";");
					//System.out.printf( "1:%s 2:%s 3:%s 4:%s  T=%d  T=%d \n" , divIdk[1] ,partes[1] ,divIdk[2] ,partes[2] , divIdk[1].compareTo(partes[1]) , divIdk[2].compareTo(partes[2]) );
					if (  divIdk[1].equalsIgnoreCase(partes[1])  && divIdk[0].equalsIgnoreCase(partes[0]) ) {
						//System.out.println("aaa");
						/// se tendria que sumar el stock de pedazo con el de partes
						int PartesInt = Integer.parseInt(partes[3]);
						int divIdkInt = Integer.parseInt(divIdk[3]);
                        String   StringdivIdkInt =String.valueOf(divIdkInt);
						int Suma = PartesInt + divIdkInt;
						//listado.get(l).replace( divIdk[3], String.valueOf( Suma) );
						//listado.set(Suma,  StringdivIdkInt);
						
						/// editar el listado no mostarar el remplazado con suma
						listado.set(l,  listado.get(l).replace( divIdk[3], String.valueOf( Suma) )  );
						
						agregar = false;
					}
				}
				
				if( agregar )
					listado.add(linea);
			}
		}

		br.close();
		fr.close();
		
		for( String a : listado )
		{
			System.out.println(a);
		}
		
	}

	static public void Vender(File archivoe) {
	    File copia = new File("copia.csv");
	    FileReader Fr = null;
	    BufferedReader Br = null;
	    FileWriter Fw = null;
	    PrintWriter Pw = null;

	    System.out.println("Inserte producto:");
	    String productoBuscado = entradaDeDatos();
	    System.out.println("Inserte marca:");
	    String MarcaBuscada = entradaDeDatos();  
	    System.out.println("Cuántos desea vender?");
	    String venta = entradaDeDatos();

	    try {
	        	        Fr = new FileReader(archivoe);
	        Br = new BufferedReader(Fr);

	       
	        Fw = new FileWriter(copia, true);  
	        Pw = new PrintWriter(Fw);

	        String renglon;
	        while ((renglon = Br.readLine()) != null) {
	            String[] partes = renglon.split(";");

	           
	            if (partes[0].equalsIgnoreCase(productoBuscado) && partes[1].equalsIgnoreCase(MarcaBuscada)) {
	                int cantActual = Integer.parseInt(partes[3]);
	                int cantidadVenta = Integer.parseInt(venta);

	                if (cantActual >= cantidadVenta) {
	                    int total = cantActual + cantidadVenta;  
	                    String nuevaCantidad = String.valueOf(total);

	                  
	                    renglon = renglon.replace(partes[3], nuevaCantidad);
	                    System.out.println("Venta realizada. Nueva cantidad: " + nuevaCantidad);
	                } else {
	                    System.out.println("No hay suficiente stock para vender.");
	                }
	            }

	            Pw.println(renglon);
	        }

	 
	        Br.close();
	        Fr.close();
	        Pw.close();
	        Fw.close();

	    
	        if (archivoe.exists()) {
	         // archivoe.delete();
	        }
	        if (copia.exists()) {
	            copia.renameTo(archivoe);
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	

	
	static public void Comprar(File archivoe) {
	    File copia = new File("inventario.csv");
	    FileReader Fr = null;
	    BufferedReader Br = null;
	    FileWriter Fw = null;
	    PrintWriter Pw = null;

	    System.out.println("Inserte producto:");
	    String productoBuscado = entradaDeDatos();
	    System.out.println("Inserte marca:");
	    String MarcaBuscada = entradaDeDatos();  
	    System.out.println("Cuántos desea vender?");
	    String venta = entradaDeDatos();

	    try {
	        	        Fr = new FileReader(archivoe);
	        Br = new BufferedReader(Fr);

	       
	        Fw = new FileWriter(copia, true);  
	        Pw = new PrintWriter(Fw);

	        String renglon;
	        while ((renglon = Br.readLine()) != null) {
	            String[] partes = renglon.split(";");

	           
	            if (partes[0].equalsIgnoreCase(productoBuscado) && partes[1].equalsIgnoreCase(MarcaBuscada)) {
	                int cantActual = Integer.parseInt(partes[3]);
	                int cantidadVenta = Integer.parseInt(venta);

	                if (cantActual >= cantidadVenta) {
	                    int total = cantActual - cantidadVenta;  
	                    String nuevaCantidad = String.valueOf(total);

	                  
	                    renglon = renglon.replace(partes[3], nuevaCantidad);
	                    System.out.println("Venta realizada. Nueva cantidad: " + nuevaCantidad);
	                } else {
	                    System.out.println("No hay suficiente stock para vender.");
	                }
	            }

	            Pw.println(renglon);
	        }

	 
	        Br.close();
	        Fr.close();
	        Pw.close();
	        Fw.close();

	    
	        if (archivoe.exists()) {
	           // archivoe.delete();
	        }
	        if (copia.exists()) {
	            copia.renameTo(archivoe);
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	

	public void createFilePrintStream(File a) {
		FileOutputStream fos = null;
	}

}
