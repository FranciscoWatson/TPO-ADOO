package main.ejemplar.ubicacion;

import java.util.ArrayList;

public class Ubicacion {
	
	private AdapterUbicacion adapter;
	private int fila;
	private int columna;

	public Ubicacion(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		this.adapter = new SistemaUbicacionFisica();
	}


	public ArrayList<Integer> obtenerUbicacion(){
		return adapter.adaptarUbicacion(fila, columna);
	}

	public void setFila(int fila) {
		this.fila = fila;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
}
