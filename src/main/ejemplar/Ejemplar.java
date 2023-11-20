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
    public int getIdEjemplar() {
        return idEjemplar;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void solicitarEjemplar() {
        estadoEjemplar = false;
    }

    public boolean getEstado() {
        return estadoEjemplar;
    }
    
    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void devolverEjemplar() {
        estadoEjemplar = true;
    }

    public ArrayList<Integer> getUbicacion() {
        return ubicacion.getUbicacion();
    }
    public void setDiasPrestamo(int diasPrestamo){
        this.diasPrestamo = diasPrestamo;
    }
}
