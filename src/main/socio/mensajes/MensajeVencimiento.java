package main.socio.mensajes;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public class MensajeVencimiento extends Mensaje{
    public MensajeVencimiento(LocalDate fecha, Prestamo prestamo) {
        this.fecha = fecha;
        this.prestamo = prestamo;
    }
    public String getMensaje(){
        return "Estimado socio, se le informa que el prestamo del libro" + prestamo.getEjemplar().getTitulo() + "esta proximo a vencerse";
    }
}
