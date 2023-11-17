import java.time.LocalDate;
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
    private MedioFavorito medioFav;
    private ArrayList<Mensaje> mensajesEnviados = new ArrayList<>();


    public Socio(int idBiblotecario, String nombre, String apellido, double dni, String mail, double telefono,MedioFavorito medioFav) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        this.medioFav = medioFav;
        this.contadorPenalizaciones = 0;
        estado = new Habilitado(this);
        notificacion = new NotificacionWhatsApp();
    }

    public double obtenerDni() {
        return dni;
    }

    public void pedirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void notificarVencimiento(Prestamo prestamo) {
        LocalDate currentDate = LocalDate.now();
        Mensaje mensaje = new MensajeVencimiento(currentDate, prestamo);
        mensajesEnviados.add(mensaje);
        notificacion.enviarNotificacion(mensaje.obtenerMensaje(), this);
        // CREAR MENSAJE + NOTIFICAR A LA ESTRATEGIA
    	//  factoryMensajeVencimiento.crearMensaje()
    }
    
    public void setNombre(int idBibliotecario, String nombreNuevo, double dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de nombre '" + this.nombre + "' -------> '" + nombreNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.nombre = nombreNuevo;
    	
    }
    
    public void setApellido(int idBibliotecario, String apellidoNuevo, double dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de apellido '" + this.apellido + "' -------> '" + apellidoNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.apellido = apellidoNuevo;
    	
    }
    
    public void setMail(int idBibliotecario, String mailNuevo, double dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de mail '" + this.mail + "' -------> '" + mailNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.mail = mailNuevo;
    	
    }
    
    public void setTelefono(int idBibliotecario, double telefonoNuevo, double dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de telefono '" + this.telefono + "' -------> '" + telefonoNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.telefono = telefonoNuevo;
    	
    }
    
    public void setMedioFav(int idBibliotecario, MedioFavorito medioFavNuevo, double dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de telefono '" + this.medioFav + "' -------> '" + medioFavNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.medioFav = medioFavNuevo;
    	
    }

    public String obtenerEmail() {
        return mail;
    }

    public double obtenerTelefono() {
        return telefono;
    }

    public void devolverPrestamo(Prestamo prestamo) {

        estado.devolverPrestamo(prestamo, this);

    }
}
