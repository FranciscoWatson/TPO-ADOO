package main.prestamo.observer;

import java.time.LocalDate;


public class Calendario extends Sujeto{

    private LocalDate fechaActual;

    public Calendario() {
        super();
        fechaActual = LocalDate.now();
    }
    public void cambioDia(){
        fechaActual = fechaActual.plusDays(1);
        notificar();
    }
    public void notificar(){
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).actualizarFecha(this);
        }
    }
    public LocalDate getFecha(){
        return fechaActual;
    }
}


