package main.socio.mensajes;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public abstract class Mensaje {
    Prestamo prestamo;
    LocalDate fecha;
    public String getMensaje() {
        return null;
    }
}
