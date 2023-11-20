package main.socio;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public abstract class Mensaje {
    Prestamo prestamo;
    LocalDate fecha;
    public String obtenerMensaje() {
        return null;
    }
}
