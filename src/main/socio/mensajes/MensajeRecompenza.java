package main.socio.mensajes;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public class MensajeRecompenza extends Mensaje{
    public MensajeRecompenza(LocalDate fecha, Prestamo prestamo) {

        this.fecha = fecha;
        this.prestamo = prestamo;
    }
    public String getMensaje(){
        return "Estimado socio, se le informa que ha recibido una recompenza por el prestamo del libro: " + prestamo.getEjemplar().getTitulo();
    }
}
