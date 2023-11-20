package main.ejemplar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class EjemplarController {
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>();


    public void nuevoRevistaEspecializada(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna) {
        Ejemplar nuevoEjemplar = new RevistaEspecializada(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoDiario(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna) {
        Ejemplar nuevoEjemplar = new Diario(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoLibro(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna) {
        Ejemplar nuevoEjemplar = new Libro(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoRevista(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna) {
        Ejemplar nuevoEjemplar = new Revista(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
        ejemplares.add(nuevoEjemplar);
    }

    public Ejemplar obtenerEjemplar(int idEjemplar) {
        for(int i = 0; i < ejemplares.size(); i++){
            if (ejemplares.get(i).obtenerIdEjemplar() == idEjemplar){
                return ejemplares.get(i);
            }
        }
        return null;
    }

    @SuppressWarnings("null")
	public ArrayList<Integer> buscarEjemplar(String busqueda) {
        ArrayList<Integer> candidatos = null;
        for(int i = 0; i < ejemplares.size(); i++){
            if (Objects.equals(ejemplares.get(i).obtenerTitulo(), busqueda) && ejemplares.get(i).obtenerEstado()){
                candidatos.add(ejemplares.get(i).obtenerIdEjemplar());
            } else if (Objects.equals(ejemplares.get(i).obtenerCategoria(), busqueda) && ejemplares.get(i).obtenerEstado()) {
                candidatos.add(ejemplares.get(i).obtenerIdEjemplar());
            } else if (Objects.equals(ejemplares.get(i).obtenerAutor(), busqueda) && ejemplares.get(i).obtenerEstado()) {
                candidatos.add(ejemplares.get(i).obtenerIdEjemplar());
            }
        }
        return candidatos;
    }
    

    public ArrayList<Integer> buscarUbicacion(int idEjemplar) {
        for(int i = 0; i < ejemplares.size(); i++){
            if (ejemplares.get(i).obtenerIdEjemplar() == idEjemplar){
                return ejemplares.get(i).obtenerUbicacion();
            }
        }
        return null;
    }
}
