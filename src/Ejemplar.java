import java.util.ArrayList;

public abstract class Ejemplar {
    private int idEjemplar;
    private String titulo;
    private String categoria;
    private String autor;
    private boolean estadoEjemplar;
    private Ubicacion ubicacion;
    public int obtenerIdEjemplar() {
        return idEjemplar;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public String obtenerAutor() {
        return autor;
    }

    public void solicitarEjemplar() {
        estadoEjemplar = false;
    }

    public boolean obtenerEstado() {
        return estadoEjemplar;
    }

    public void devolverEjemplar() {
        estadoEjemplar = true;
    }

	public ArrayList<Integer> obtenerUbicacion(Ejemplar this) {
		ArrayList<Integer> filaColumna = ubicacion.obtenerUbicacion(this.idEjemplar);
		return filaColumna;
	}
}
