import java.time.LocalDate;
import java.util.ArrayList;

public class PrestamoController {
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    Calendario calendario;

    public PrestamoController(Calendario calendario) {
        this.calendario = calendario;
    }
    public PrestamoController() {
    }


    public void pedirPrestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar, LocalDate fechaVencimiento) {
        Prestamo nuevoPrestamo = new Prestamo(idBiblotecario, socio, ejemplar, fechaVencimiento);
        prestamos.add(nuevoPrestamo);
        calendario.agregarObservador(nuevoPrestamo);
    }

    public void devolverPrestamo(int idPrestamo) {
        for(int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).obtenerIdPrestamo() == idPrestamo){
                 prestamos.get(i).devolverPrestamo();
            }
        }
    }
}