package main.ejemplar.ubicacion;

import java.util.ArrayList;

public interface AdapterUbicacion {

	ArrayList<Integer> obtenerUbicacion(int idEjemplar);


	ArrayList<Integer> adaptarUbicacion(int fila, int columna);
}
