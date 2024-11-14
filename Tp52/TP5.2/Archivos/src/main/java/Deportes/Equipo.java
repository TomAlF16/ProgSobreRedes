package Deportes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equipo {
    List<Atleta> equipo;
    String nombreEquipo;
    ArrayList<String> actividades;
    int IndiceDelAtleta;
    ArrayList<String> ganadores;
    int tiempo;
    private List<Integer> timer;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.equipo = new ArrayList<>();
        this.actividades = new ArrayList<>(Arrays.asList("remo", "correr", "nadar", "bici"));
        this.ganadores = new ArrayList<>(); // Inicialización de ganadores
        this.timer = new ArrayList<>(); // Inicialización de timer si es necesario
    }

    public String getActividad() {
        return actividades.get(IndiceDelAtleta % actividades.size());
    }

    public void setEquipo(List<Atleta> equipo) {
        this.equipo = equipo;
    }

    public List<Integer> getTimer() {
        return timer;
    }

    public void setActividades(ArrayList<String> actividades) {
        this.actividades = actividades;
    }

    public void setIndiceDelAtleta(int IndiceDelAtleta) {
        this.IndiceDelAtleta = IndiceDelAtleta;
    }

    public void setGanadores(ArrayList<String> ganadores) {
        this.ganadores = ganadores;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public List<Atleta> getEquipo() {
        return equipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setEquipo(ArrayList<Atleta> equipo) {
        this.equipo = equipo;
    }

    public int getIndiceDelAtleta() {
        return IndiceDelAtleta;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public ArrayList<String> getActividades() {
        return actividades;
    }

    public ArrayList<String> getGanadores() {
        return ganadores;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void AñadirAtleta(Atleta atleta) {
        equipo.add(atleta);
    }

    public synchronized void agregarTiempo(int tiempoV) {
        tiempo += tiempoV;
    }

    public synchronized void cambiarPosta() {
        if (IndiceDelAtleta < equipo.size() - 1) {
            IndiceDelAtleta++;
            Atleta Siguiente = equipo.get(IndiceDelAtleta);
            Siguiente.setPosta(true);
            Siguiente.start();
        } else {
            ganadores.add(nombreEquipo); // Agregar nombre del equipo a ganadores
        }
        notifyAll();
    }

    public void ComenzarCarrera() {
        if (!equipo.isEmpty()) {
            equipo.get(0).setPosta(true);
            equipo.get(0).start();
        }
    }
}