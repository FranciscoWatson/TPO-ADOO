package main.socio;

import main.prestamo.Prestamo;
import main.socio.estadoSocio.EstadoSocio;
import main.socio.estadoSocio.Habilitado;
import main.socio.estadoSocio.Suspendido;
import main.socio.estrategiaNotificacion.EstrategiaNotificacion;
import main.socio.estrategiaNotificacion.NotificacionWhatsApp;
import main.socio.mensajes.Mensaje;
import main.socio.mensajes.MensajeVencimiento;

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
        this.dataLog = new DataLog();
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

    public int getDni() {
        return dni;
    }

    public void pedirPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public void notificarVencimiento(Prestamo prestamo) {
        LocalDate currentDate = LocalDate.now();
        Mensaje mensaje = new MensajeVencimiento(currentDate, prestamo);
        mensajesEnviados.add(mensaje);
        notificacion.enviarNotificacion(mensaje.getMensaje(), this);
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

    public String getEmail() {
        return mail;
    }

    public int getTelefono() {
        return telefono;
    }
    
    public int getDiasHabiles() {
    	return diasHabiles;
    }

    public void devolverPrestamo(Prestamo prestamo, LocalDate fechaActual) {
        estado.devolverPrestamo(prestamo, this, fechaActual);
    }

    public EstadoSocio getEstado(){
        return estado;
    }

    public ArrayList<String> getModificaciones(){
        return dataLog.getModificaciones();
    }
    
}
