import java.util.ArrayList;

public class Socio {
    private String nombre;
    private String apellido;
    private double dni;
    private String mail;
    private double telefono;
    private int contadorPenalizaciones;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private EstadoSocio estado;
    private EstrategiaNotificacion notificacion;
    private DataLog dataLog;

    public Socio(int idBiblotecario, String nombre, String apellido, double dni, String mail, double telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        estado = new Habilitado();
        notificacion = new NotificacionEmail();
    }

    public double obtenerDni() {
        return dni;
    }
}
