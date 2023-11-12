public abstract class Ejemplar {
    private int idEjemplar;
    private String titulo;
    private String categoria;
    private String autor;
    public int obtenerIdEjemplar() {
        return idEjemplar;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public String obtenerAutor() {
        return autor;
    }
}
