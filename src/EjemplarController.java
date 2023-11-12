import java.util.ArrayList;
import java.util.Date;

public class EjemplarController {
    private ArrayList<Ejemplar> ejemplares = new ArrayList<>();


    public void nuevoRevistaEspecializada(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar) {
        Ejemplar nuevoEjemplar = new RevistaEspecializada(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoDiario(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar) {
        Ejemplar nuevoEjemplar = new Diario(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoLibro(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar) {
        Ejemplar nuevoEjemplar = new Libro(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
        ejemplares.add(nuevoEjemplar);
    }

    public void nuevoRevista(String titulo, String autor, int diasPrestamo, Date fechaPublicacion, String categoria, int idEjemplar) {
        Ejemplar nuevoEjemplar = new Revista(titulo, autor, diasPrestamo, fechaPublicacion, categoria, idEjemplar);
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
}
