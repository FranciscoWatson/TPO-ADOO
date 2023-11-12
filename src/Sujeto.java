import java.util.ArrayList;

public abstract class Sujeto {
    private ArrayList<Observador> observadores;
    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }
    public void notificar(){
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).actualizarFecha(this);
        }
    }
}
