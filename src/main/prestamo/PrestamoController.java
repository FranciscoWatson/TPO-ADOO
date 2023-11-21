package main.prestamo;

import main.ejemplar.Ejemplar;
import main.prestamo.observer.Calendario;
import main.socio.Socio;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrestamoController {
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    Calendario calendario;

    public PrestamoController(Calendario calendario) {
        this.calendario = calendario;
    }
    public PrestamoController() {
    }


    public void pedirPrestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar) {
    	if(socio.getDiasHabiles() == -10) {
    		System.out.println("Este usuario se encuentra suspendido.");
    	}
    	
    	else {
    		if((ejemplar.getDiasPrestamo() + socio.getDiasHabiles()) <= 0) {
        		System.out.println("El usuario tiene demasiadas penalizaciones para este libro.");
        	}
    		else {
    			int idPrestamo = prestamos.size() + 1;
		        Prestamo nuevoPrestamo = new Prestamo(idBiblotecario, socio, ejemplar, idPrestamo, calendario.getFecha());
		        prestamos.add(nuevoPrestamo);
		        calendario.agregarObservador(nuevoPrestamo);
    		}
    	}
    }

    public void devolverPrestamo(int idPrestamo) {
        for(int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).getIdPrestamo() == idPrestamo){
                 prestamos.get(i).devolverPrestamo(calendario.getFecha());
            }
        }
    }
    public Prestamo getPrestamo(int idPrestamo){
            for(int i = 0; i < prestamos.size(); i++){
                if (prestamos.get(i).getIdPrestamo() == idPrestamo){
                    return prestamos.get(i);

            }
        }
        return null;
    }
    public void agregarDias(int dias,int id) {
    	getPrestamo(id).agregarDias(dias);;
    }
    public LocalDate getFechaVec(int idPrestamo) {
		return getPrestamo(idPrestamo).obtenerFechaVencimiento();
	}
    
}