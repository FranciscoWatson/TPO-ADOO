import java.util.ArrayList;

public class PrestamoController {
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void pedirPrestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar) {
        Prestamo nuevoPrestamo = new Prestamo(idBiblotecario, socio, ejemplar);
        prestamos.add(nuevoPrestamo);
    }

    public void devolverPrestamo(int idPrestamo) {
        for(int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).obtenerIdPrestamo() == idPrestamo){
                 prestamos.get(i).devolverPrestamo();
            }
        }
    }
}