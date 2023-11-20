package main.prestamo;

import main.ejemplar.Ejemplar;
import main.socio.Socio;

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
    	if(socio.obtenerDiasHabiles() == -10) {
    		System.out.println("Este usuario se encuentra suspendido.");
    	}
    	
    	else {
    		if((ejemplar.obtenerDiasPrestamo() + socio.obtenerDiasHabiles()) <= 0) {
        		System.out.println("El usuario tiene demasiadas penalizaciones para este libro.");
        	}
    		else {
    			int idPrestamo = prestamos.size() + 1;
		        Prestamo nuevoPrestamo = new Prestamo(idBiblotecario, socio, ejemplar, idPrestamo);
		        prestamos.add(nuevoPrestamo);
		        calendario.agregarObservador(nuevoPrestamo);
    		}
    	}
    }

    public void devolverPrestamo(int idPrestamo) {
        for(int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).obtenerIdPrestamo() == idPrestamo){
                 prestamos.get(i).devolverPrestamo();
            }
        }
    }
    public Prestamo obtenerPrestamo(int idPrestamo){
            for(int i = 0; i < prestamos.size(); i++){
                if (prestamos.get(i).obtenerIdPrestamo() == idPrestamo){
                    return prestamos.get(i);

            }
        }
        return null;
    }
}