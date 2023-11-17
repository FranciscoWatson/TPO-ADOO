import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo implements Observador{
    private int idPrestamo;
    private int idBiblotecario;
    private Socio socio;
    private Ejemplar ejemplar;
    private LocalDate fechaVencimiento;
    public Prestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar, LocalDate fechaVencimiento) {
        this.idBiblotecario = idBiblotecario;
        this.socio = socio;
        this.ejemplar = ejemplar;
        this.fechaVencimiento = fechaVencimiento;
        ejemplar.solicitarEjemplar();
        socio.pedirPrestamo(this);
    }

    public int obtenerIdPrestamo() {
        return idPrestamo;
    }

    public void devolverPrestamo() {
        ejemplar.devolverEjemplar();
        socio.devolverPrestamo(this);
    }

    @Override
    public void actualizarFecha(Calendario calendario) {
        long diferenciaEnDias = ChronoUnit.DAYS.between(calendario.obtenerFecha(), fechaVencimiento);
        if ( diferenciaEnDias <= 2 ){
            socio.notificarVencimiento(this);
        }


    }

    public Ejemplar obtenerEjemplar() {
        return ejemplar;
    }
}
