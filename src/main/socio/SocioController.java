package main.socio;

import java.util.ArrayList;

public class SocioController {

    private ArrayList<Socio> socios = new ArrayList<>();
    
    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono) {
        Socio nuevoSocio = new Socio(idBiblotecario, nombre, apellido, dni, mail, telefono, MedioFavorito.EMAIL);
        socios.add(nuevoSocio);
    }
    
    //Agrego este para armar casos personalizados de socios con dias ya cargados
    public void nuevoSocio(int idBiblotecario, String nombre, String apellido, int dni, String mail, int telefono,int diasPlus) {
        Socio nuevoSocio = new Socio(idBiblotecario, nombre, apellido, dni, mail, telefono, MedioFavorito.EMAIL, diasPlus);
        socios.add(nuevoSocio);
    }

    public Socio getSocio(double dni) {
        for(int i = 0; i < socios.size(); i++){
            if (socios.get(i).getDni() == dni){
                return socios.get(i);
            }
        }

        return null;
    }
    
    public void setNombre(int idBibliotecario, String nombre, double dni) {
    	Socio socio = getSocio(dni);
    	socio.setNombre(idBibliotecario, nombre, dni);
    }
    
    public void setApellido(int idBibliotecario, String apellidoNuevo, double dni) {
    	Socio socio = getSocio(dni);
    	socio.setApellido(idBibliotecario, apellidoNuevo, dni);
    }
    
    public void setMail(int idBibliotecario, String mailNuevo, int dni) {
    	Socio socio = getSocio(dni);
    	socio.setMail(idBibliotecario, mailNuevo, dni);
    }
    
    public void setTelefono(int idBibliotecario, int telefonoNuevo, int dni) {
    	Socio socio = getSocio(dni);
    	socio.setTelefono(idBibliotecario, telefonoNuevo, dni);
    }
    
    public void setMedioFav(int idBibliotecario, String medioFavNuevo, double dni) {
    	Socio socio = getSocio(dni);
    	socio.setTelefono(idBibliotecario, idBibliotecario, dni);
        socio.setMedioFav(1,medioFavNuevo,dni);
    }
    public ArrayList<Socio> getSocios(){
        return socios;
    }

    public ArrayList<String> getModificaciones(double dni){
        return getSocio(dni).getModificaciones();
    }
    	 
}
