import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static SistemaBibloteca sistemaBibloteca;
    public static void main(String[] args) {
        sistemaBibloteca = new SistemaBibloteca();
        Calendario calendario = new Calendario();
        sistemaBibloteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBibloteca.nuevoLibro("Harry Potter", "asd", 3, LocalDate.of(2010,2,2), "accion", 1);
        sistemaBibloteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 2);
        sistemaBibloteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();



    }
}