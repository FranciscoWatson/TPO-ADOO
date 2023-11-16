import java.time.LocalDate;

public class Calendario extends Sujeto{

    private LocalDate fechaActual;

    public Calendario() {
        super();
        fechaActual = LocalDate.now();
    }
    public void cambioDia(){
        fechaActual.plusDays(1);
        notificar();
    }
    public LocalDate obtenerFecha(){
        return fechaActual;
    }
}
