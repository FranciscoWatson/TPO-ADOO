import java.util.ArrayList;

public class Ubicacion {
	
	private AdapterUbicacion adapter;

	public ArrayList<Integer> obtenerUbicacion(int idEjemplar) {
		ArrayList<Integer> filaColumna = adapter.obtenerUbicacion(idEjemplar);
		return filaColumna;
	}
}
