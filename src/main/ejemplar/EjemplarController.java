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

    public Ejemplar getEjemplar(int idEjemplar) {
        for(int i = 0; i < ejemplares.size(); i++){
            if (ejemplares.get(i).getIdEjemplar() == idEjemplar){
                return ejemplares.get(i);
            }
        }
        return null;
    }

    @SuppressWarnings("null")
	public ArrayList<Integer> buscarEjemplar(String busqueda) {
        ArrayList<Integer> candidatos = null;
        for(int i = 0; i < ejemplares.size(); i++){
            if (Objects.equals(ejemplares.get(i).getTitulo(), busqueda) && ejemplares.get(i).getEstado()){
                candidatos.add(ejemplares.get(i).getIdEjemplar());
            } else if (Objects.equals(ejemplares.get(i).getCategoria(), busqueda) && ejemplares.get(i).getEstado()) {
                candidatos.add(ejemplares.get(i).getIdEjemplar());
            } else if (Objects.equals(ejemplares.get(i).getAutor(), busqueda) && ejemplares.get(i).getEstado()) {
                candidatos.add(ejemplares.get(i).getIdEjemplar());
            }
        }
        return candidatos;
    }
    

    public ArrayList<Integer> buscarUbicacion(int idEjemplar) {
        for(int i = 0; i < ejemplares.size(); i++){
            if (ejemplares.get(i).getIdEjemplar() == idEjemplar){
                return ejemplares.get(i).getUbicacion();
            }
        }
        return null;
    }

    public void cambiarDiasPrestamo(int idEjemplar, int diasPrestamo){
        for(int i = 0; i < ejemplares.size(); i++){
            if (ejemplares.get(i).getIdEjemplar() == idEjemplar){
                ejemplares.get(i).setDiasPrestamo(diasPrestamo);
            }
        }
    }
}
