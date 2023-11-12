import java.util.Date;

public class Prestamo implements Observador{
    private int idPrestamo;
    private int idBiblotecario;
    private Socio socio;
    private Ejemplar ejemplar;
    private Date fechaVencimiento;
    public Prestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar) {
        this.idBiblotecario = idBiblotecario;
        this.socio = socio;
        this.ejemplar = ejemplar;
        ejemplar.solicitarEjemplar();
        socio.pedirPrestamo(this);
    }

    public int obtenerIdPrestamo() {
        return idPrestamo;
    }

    public void devolverPrestamo() {
        ejemplar.devolverEjemplar();
       // agregar contador penalizaciones
        //socio.devolverPrestamo();
    }

    @Override
    public void actualizarFecha(Sujeto sujeto) {
        socio.notificarVencimiento();

    }
}
