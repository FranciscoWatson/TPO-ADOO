import java.util.Date;

public class SistemaBibloteca {
    private PrestamoController prestamoController;
    private EjemplarController ejemplarController;
    private SocioController socioController;

    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, double dni, String mail, double telefono){
        socioController.nuevoSocio(idBiblotecario, nombre, apellido, dni, mail, telefono);

    }
    private void nuevoRevistaEspecializada(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoRevistaEspecializada(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    private void nuevoDiario(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoDiario(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    private void nuevoLibro(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoLibro(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
    private void nuevoRevista(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar){
        ejemplarController.nuevoRevista(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
    }
}