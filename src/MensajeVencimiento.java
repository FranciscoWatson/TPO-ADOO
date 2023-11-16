import java.time.LocalDate;

public class MensajeVencimiento extends Mensaje{
    public MensajeVencimiento(LocalDate fecha, Prestamo prestamo) {
        this.fecha = fecha;
        this.prestamo = prestamo;
    }
    public String obtenerMensaje(){
        return "Estimado socio, se le informa que el prestamo del libro" + prestamo.obtenerEjemplar().obtenerTitulo() + "esta proximo a vencerse";
    }
}
