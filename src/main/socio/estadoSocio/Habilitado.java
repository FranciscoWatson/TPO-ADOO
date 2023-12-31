package main.socio.estadoSocio;

import main.prestamo.Prestamo;
import main.socio.Socio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Habilitado extends EstadoSocio {
	int contadorBonificacion;
    public Habilitado(Socio socio) {
    	contadorBonificacion = 0;
        this.socio = socio;
    }

    @Override
    public void devolverPrestamo(Prestamo prestamo, Socio socio, LocalDate fechaActual) {
    	//Chequeo si se entrego en tiempo y forma y si es asi sumo 1 al contadorBonificacion :D
    	if(fechaActual.isBefore(prestamo.obtenerFechaVencimiento()) || fechaActual.isEqual(prestamo.obtenerFechaVencimiento())){
    		contadorBonificacion += 1;

    		//Si llego a 5, le sumamos un dia a los dias del socio
    		if (this.contadorBonificacion == 5){
    			this.contadorBonificacion = 0;
    			socio.setDiasHabiles(socio.getDiasHabiles() +1);
				socio.notificarBonificacion(prestamo);
    		}
    	}
    	//Si no entrego en tiempo y forma se pudre >:(
    	else {
    		int diferenciaDias = (int) ChronoUnit.DAYS.between(fechaActual, prestamo.obtenerFechaVencimiento());
    		//Penalizo la bonificacion
    		contadorBonificacion = 0;
    		//Si los dias que hay q descontarle al socio lo deja en 0 o menos, lo suspendemos
    		if ((socio.getDiasHabiles() + diferenciaDias) <= -10) {
    			Suspendido suspendido = new Suspendido(socio);
    			socio.setEstadoSocio(suspendido);
    			socio.setDiasHabiles(-10);
				socio.notificarPenalizacion(prestamo);
    			System.out.println("El socio con DNI: " + socio.getDni() + " fue suspendido. Contactarse con administracion");
    		}
    		//Sino simplemente le restamos los dias
    		else {
    			socio.setDiasHabiles(socio.getDiasHabiles() + diferenciaDias);
				socio.notificarPenalizacion(prestamo);
    		}
    		
    	}
    		
    }
    	

}

