package main.prestamo;

import main.ejemplar.Ejemplar;
import main.prestamo.observer.Calendario;
import main.prestamo.observer.Observador;
import main.socio.Socio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo implements Observador {
    private int idPrestamo;
    private Socio socio;
    private Ejemplar ejemplar;
    private LocalDate fechaVencimiento;
    
    public Prestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar, int idPrestamo) {
    	this.idPrestamo = idPrestamo;
        this.socio = socio;
        this.ejemplar = ejemplar;
        int diasEjemplar = ejemplar.getDiasPrestamo();
        LocalDate fechaActual = LocalDate.now();
        fechaActual = fechaActual.plusDays(diasEjemplar);
        this.fechaVencimiento = fechaActual.plusDays(socio.getDiasHabiles());
     //   System.out.println("fechaVec:" + fechaVencimiento);
        ejemplar.solicitarEjemplar();
        socio.pedirPrestamo(this);
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }
    
    public LocalDate obtenerFechaVencimiento() {
    	return fechaVencimiento;
    }

    public void devolverPrestamo(LocalDate fechaActual) {
        ejemplar.devolverEjemplar();
        socio.devolverPrestamo(this, fechaActual);
    }

    @Override
    public void actualizarFecha(Calendario calendario) {
        long diferenciaEnDias = ChronoUnit.DAYS.between(calendario.getFecha(), fechaVencimiento);
        if ( diferenciaEnDias <= 2 ){
            socio.notificarVencimiento(this);
        }


    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }


}
