package main.ejemplar;

import java.time.LocalDate;

public class RevistaEspecializada extends Ejemplar {
    public RevistaEspecializada(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar) {
        this.titulo = titulo;
        this.autor = autor;
        this.diasPrestamo = diasPrestamo;
        this.fechaPublicacion = fechaPublicacion;
        this.categoria = categoria;
        this.idEjemplar = idEjemplar;
    }
}
