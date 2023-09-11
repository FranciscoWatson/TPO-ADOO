public class Registro {
    Prestamo prestamo;

    public void solicitarPrestamo(Socio socio, Ejemplar ejemplar){
        prestamo = new Prestamo(socio, ejemplar);
    }
}
