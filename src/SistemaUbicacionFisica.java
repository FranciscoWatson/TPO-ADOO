import java.util.ArrayList;

public class SistemaUbicacionFisica implements AdapterUbicacion {

	@Override
	public ArrayList<Integer> obtenerUbicacion(int idEjemplar) {
		ArrayList<Integer> filaColumna = new ArrayList<>();
		filaColumna.add(4);
		filaColumna.add(6);
		return filaColumna;
	}
}
