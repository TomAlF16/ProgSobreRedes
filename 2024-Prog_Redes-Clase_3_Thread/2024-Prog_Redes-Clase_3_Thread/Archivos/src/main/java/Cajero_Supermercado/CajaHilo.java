package Cajero_Supermercado;

import java.util.ArrayList;

public class CajaHilo extends Thread {

	
  private int numCaja;
  private String NombreCajero;
  private long tiempoInicial;
  private ArrayList<Persona> filaClientes;

	public CajaHilo (int nro, String nom, long ti,ArrayList<Persona> listCli) {
		this.numCaja = nro;
		this.NombreCajero =nom;
		this.tiempoInicial =ti;
		this.filaClientes = listCli;
}
@Override
public void run() {}
}
