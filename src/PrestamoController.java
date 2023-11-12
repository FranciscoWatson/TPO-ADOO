import java.util.ArrayList;

public class PrestamoController {
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void pedirPrestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar) {
        Prestamo nuevoPrestamo = new Prestamo(idBiblotecario, socio, ejemplar);
    }
}