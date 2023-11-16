import java.util.ArrayList;

public abstract class Sujeto {
    protected ArrayList<Observador> observadores;
    protected static Sujeto instance;

    Sujeto() {
        observadores = new ArrayList<>();
    }

    public static synchronized Sujeto getInstance() {
        if (instance == null) {
            instance = new Sujeto() {
            };
        }
        return instance;
    }
    public void agregarObservador(Observador observador){
        observadores.add(observador);
    }
    public void notificar(){
        for (int i = 0; i < observadores.size(); i++){
            observadores.get(i).actualizarFecha(this);
        }
    }
}
