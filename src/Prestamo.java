public class Prestamo implements Observador{
    private int idBiblotecario;
    private Socio socio;
    private Ejemplar ejemplar;
    public Prestamo(int idBiblotecario, Socio socio, Ejemplar ejemplar) {
        this.idBiblotecario = idBiblotecario;
        this.socio = socio;
        this.ejemplar = ejemplar;
    }
}
