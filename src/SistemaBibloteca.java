import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class SistemaBibloteca {
    private PrestamoController prestamoController;
    private EjemplarController ejemplarController;
    private SocioController socioController;

    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, double dni, String mail, double telefono){
        socioController.nuevoSocio(idBiblotecario, nombre, apellido, dni, mail, telefono);

    }
    public void nuevoRevistaEspecializada(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoRevistaEspecializada(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    public void nuevoDiario(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoDiario(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    public void nuevoLibro(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoLibro(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    public void nuevoRevista(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoRevista(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    public void pedirPrestamo(int idBiblotecario, double dni, int idEjemplar){
        Socio socio = socioController.obtenerSocio(dni);
        Ejemplar ejemplar = ejemplarController.obtenerEjemplar(idEjemplar);
        prestamoController.pedirPrestamo(idBiblotecario, socio, ejemplar);

    }
    public ArrayList<Integer> buscarEjemplar(String busqueda){
        return ejemplarController.buscarEjemplar(busqueda);
    }

}