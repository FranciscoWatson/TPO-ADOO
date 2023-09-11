public class Socio {
    private String nombre;
    private String apellido;
    private double dni;
    private String mail;
    private double numeroTelefono;
    private Notificacion notificacion = new NotificacionWhatsapp();
    private EstadoSocio estadoSocio = new Habilitado();

}
