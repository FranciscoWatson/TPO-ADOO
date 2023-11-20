package main.ejemplar.ubicacion;

import java.util.ArrayList;

public class SistemaUbicacionFisica implements AdapterUbicacion {


	@Override
	public ArrayList<Integer> adaptarUbicacion(int fila, int columna){
		ArrayList<Integer> filaColumna = new ArrayList<>();
		filaColumna.add(fila);
		filaColumna.add(columna);
		return filaColumna;
	}
}
