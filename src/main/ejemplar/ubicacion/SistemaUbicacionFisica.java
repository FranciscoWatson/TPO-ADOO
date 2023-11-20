package main.ejemplar.ubicacion;

import java.util.ArrayList;

public class SistemaUbicacionFisica implements AdapterUbicacion {

	@Override
	public ArrayList<Integer> obtenerUbicacion(int idEjemplar) {
		ArrayList<Integer> filaColumna = new ArrayList<>();
		filaColumna.add(4);
		filaColumna.add(6);
		return filaColumna;
	}
	@Override
	public ArrayList<Integer> adaptarUbicacion(int fila, int columna){
		ArrayList<Integer> filaColumna = new ArrayList<>();
		filaColumna.add(fila);
		filaColumna.add(columna);
		return filaColumna;
	}
}
