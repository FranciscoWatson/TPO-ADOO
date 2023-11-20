package main.ejemplar;

import main.ejemplar.ubicacion.Ubicacion;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Ejemplar {
    protected int idEjemplar;
    protected String titulo;
    protected String categoria;
    protected String autor;
    protected boolean estadoEjemplar;
    protected Ubicacion ubicacion;
    protected int diasPrestamo;
    protected LocalDate fechaPublicacion;
    public int obtenerIdEjemplar() {
        return idEjemplar;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public String obtenerAutor() {
        return autor;
    }

    public void solicitarEjemplar() {
        estadoEjemplar = false;
    }

    public boolean obtenerEstado() {
        return estadoEjemplar;
    }
    
    public int obtenerDiasPrestamo() {
        return diasPrestamo;
    }

    public void devolverEjemplar() {
        estadoEjemplar = true;
    }

    public ArrayList<Integer> obtenerUbicacion() {
        return ubicacion.obtenerUbicacion();
    }
    public void setDiasPrestamo(int diasPrestamo){
        this.diasPrestamo = diasPrestamo;
    }
}
