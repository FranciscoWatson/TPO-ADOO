package main.socio;

import main.prestamo.Prestamo;

import java.time.LocalDate;
import java.util.ArrayList;


public class Socio {
    private String nombre;
    private String apellido;
    private int dni;
    private String mail;
    private int telefono;
    private int diasHabiles;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private EstadoSocio estado;
    private EstrategiaNotificacion notificacion;
    private DataLog dataLog;
    private MedioFavorito medioFav;
    private ArrayList<Mensaje> mensajesEnviados = new ArrayList<>();

    public Socio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono,MedioFavorito medioFav) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        this.medioFav = medioFav;
        this.diasHabiles = 0;
        estado = new Habilitado(this);
        notificacion = new NotificacionWhatsApp();
    }
    
    //Agrego este para armar casos personalizados de socios con dias ya cargados
    public Socio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono,MedioFavorito medioFav, int diasPlus) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        this.medioFav = medioFav;
        this.diasHabiles = diasPlus;
        if(diasHabiles > -10) estado = new Habilitado(this);
        else estado = new Suspendido(this);
        notificacion = new NotificacionWhatsApp();
    }

    public int obtenerDni() {
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
    
    public void setNombre(int idBibliotecario, String nombreNuevo, int dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de nombre '" + this.nombre + "' -------> '" + nombreNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.nombre = nombreNuevo;
    	
    }
    
    public void setApellido(int idBibliotecario, String apellidoNuevo, int dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de apellido '" + this.apellido + "' -------> '" + apellidoNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.apellido = apellidoNuevo;
    	
    }
    
    public void setMail(int idBibliotecario, String mailNuevo, int dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de mail '" + this.mail + "' -------> '" + mailNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.mail = mailNuevo;
    	
    }
    
    public void setTelefono(int idBibliotecario, int telefonoNuevo, int dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de telefono '" + this.telefono + "' -------> '" + telefonoNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.telefono = telefonoNuevo;
    	
    }
    
    public void setMedioFav(int idBibliotecario, MedioFavorito medioFavNuevo, int dni) {
    	String log = "BIBLIOTECARIO: "+ idBibliotecario + ", SOCIO: " + dni + " .Cambio de telefono '" + this.medioFav + "' -------> '" + medioFavNuevo + "'." ;
    	dataLog.registrarModificacion(log);
    	this.medioFav = medioFavNuevo;
    	
    }
    public void setEstadoSocio(EstadoSocio nuevoEstado) {
    	this.estado = nuevoEstado;
    }
    
    public void setDiasHabiles(int nuevosDias) {
    	this.diasHabiles = nuevosDias;
    }

    public String obtenerEmail() {
        return mail;
    }

    public int obtenerTelefono() {
        return telefono;
    }
    
    public int obtenerDiasHabiles() {
    	return diasHabiles;
    }

    public void devolverPrestamo(Prestamo prestamo) {
        estado.devolverPrestamo(prestamo, this);
    }

    public EstadoSocio obtenerEstado(){
        return estado;
    }
    
}
