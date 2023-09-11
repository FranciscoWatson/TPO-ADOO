public class SistemaBibloteca {

    private Registro registro = new Registro();

    public void solicitarPrestamo(Socio socio, Ejemplar ejemplar){
        registro.solicitarPrestamo(new Socio(), new Libro());
    }
}
