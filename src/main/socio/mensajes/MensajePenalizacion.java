package main.socio.mensajes;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public class MensajePenalizacion extends Mensaje{

    public MensajePenalizacion(LocalDate fecha, Prestamo prestamo) {
        this.prestamo = prestamo;
        this.fecha = fecha;
    }
    public String getMensaje(){
        return "Estimado socio, se le informa ha recibido una penalizacion por el prestamo del libro: " + prestamo.getEjemplar().getTitulo() ;
    }
}
