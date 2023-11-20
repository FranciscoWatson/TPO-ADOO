package main.Facade;

import main.ejemplar.Ejemplar;
import main.ejemplar.EjemplarController;
import main.prestamo.Calendario;
import main.prestamo.PrestamoController;
import main.socio.Socio;
import main.socio.SocioController;

import java.util.ArrayList;


import java.time.LocalDate;

public class SistemaBiblioteca {
    private PrestamoController prestamoController;
    private EjemplarController ejemplarController;
    private SocioController socioController;
    
    public SistemaBiblioteca(){
        prestamoController = new PrestamoController();
        ejemplarController = new EjemplarController();
        socioController = new SocioController();
    }
    public SistemaBiblioteca(Calendario calendario){
        prestamoController = new PrestamoController(calendario);
        ejemplarController = new EjemplarController();
        socioController = new SocioController();

    }

    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono){
        socioController.nuevoSocio(idBiblotecario, nombre, apellido, dni, mail, telefono);

    }
    
    //Agrego este para armar casos personalizados de socios con dias ya cargados
    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono,int diasPlus){
        socioController.nuevoSocio(idBiblotecario, nombre, apellido, dni, mail, telefono,diasPlus);

    }
    public void nuevoRevistaEspecializada(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna){
        ejemplarController.nuevoRevistaEspecializada(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
    }
    public void nuevoDiario(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna){
        ejemplarController.nuevoDiario(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
    }
    public void nuevoLibro(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna){
        ejemplarController.nuevoLibro(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
    }
    public void nuevoRevista(String titulo, String autor, int diasPrestamo, LocalDate fechaPublicacion, String categoria, int idEjemplar, int fila, int columna){
        ejemplarController.nuevoRevista(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar, fila, columna);
    }
    public void pedirPrestamo(int idBiblotecario, int dni, int idEjemplar){
        Socio socio = socioController.obtenerSocio(dni);
        Ejemplar ejemplar = ejemplarController.obtenerEjemplar(idEjemplar);
        prestamoController.pedirPrestamo(idBiblotecario, socio, ejemplar);

    }
    public ArrayList<Integer> buscarEjemplar(String busqueda){
        return ejemplarController.buscarEjemplar(busqueda);
    }
    public void devolverPrestamo(int idPrestamo){
        prestamoController.devolverPrestamo(idPrestamo);
    }

    public SocioController obtenerSocioController(){
        return socioController;
    }

    public EjemplarController obtenerEjemplarControler() {
        return ejemplarController;
    }

    public PrestamoController obtenerPrestamoController() {
        return prestamoController;
    }

    public String verHistorialPrestamo(){

        return null;
    }

    public ArrayList<Integer> buscarUbicacion(int idEjemplar){
        return ejemplarController.buscarUbicacion(idEjemplar);
    }
    public void cambiarDiasPrestamo(int idEjemplar, int diasPrestamo){
        ejemplarController.cambiarDiasPrestamo(idEjemplar, diasPrestamo);
    }
}