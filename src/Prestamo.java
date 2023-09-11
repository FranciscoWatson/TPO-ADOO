import java.util.Date;
public class Prestamo {
    private Date fechaVencimiento;
    private Socio socio;
    private Ejemplar ejemplar;

    public Prestamo(Socio socio, Ejemplar ejemplar){
        this.socio = socio;
        this.ejemplar = ejemplar;
    }
    public void solicitarPrestamo(Socio socio, Ejemplar ejemplar){

    }
}
