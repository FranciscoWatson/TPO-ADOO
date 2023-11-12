import java.util.ArrayList;

public class SocioController {

    private ArrayList<Socio> socios = new ArrayList<>();
    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, double dni, String mail, double telefono) {
        Socio nuevoSocio = new Socio(idBiblotecario, nombre, apellido, dni, mail, telefono);
        socios.add(nuevoSocio);
    }

    public Socio obtenerSocio(double dni) {
        for(int i = 0; i < socios.size(); i++){
            if (socios.get(i).obtenerDni() == dni){
                return socios.get(i);
            }
        }

        return null;
    }
}
