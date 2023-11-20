package main.socio.estadoSocio;

import main.prestamo.Prestamo;
import main.socio.Socio;

import java.time.LocalDate;

public class Suspendido extends EstadoSocio {

	public Suspendido(Socio socio) {
		this.socio = socio;
	}
	public void devolverPrestamo(Prestamo prestamo, Socio socio, LocalDate fechaActual) {
		
	}
}
