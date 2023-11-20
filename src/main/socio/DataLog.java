package main.socio;

import java.util.ArrayList;

public class DataLog {
	
	 private ArrayList<String> modificaciones = new ArrayList<>();
	 
	 public void registrarModificacion(String log) {
		 modificaciones.add(log);
	 }
}
