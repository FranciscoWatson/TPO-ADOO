package main.socio;

import main.prestamo.Prestamo;

import java.time.LocalDate;

public class Suspendido extends EstadoSocio {

	public Suspendido(Socio socio) {
		this.socio = socio;
	}
	public void devolverPrestamo(Prestamo prestamo, Socio socio, LocalDate fechaActual) {
		
	}
}
