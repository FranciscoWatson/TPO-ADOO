package main.prestamo.observer;

import java.util.ArrayList;

public abstract class Sujeto {
    protected ArrayList<Observador> observadores;

    Sujeto() {
        observadores = new ArrayList<>();
    }


    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }
    public void notificar(){
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).actualizarFecha((Calendario) this);
        }
    }
}