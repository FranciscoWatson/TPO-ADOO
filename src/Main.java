import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static SistemaBiblioteca sistemaBiblioteca;
    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoSocio(2, "MeVan", "ASuspender", 44517985, "elbaneado@gmail.com", 111522002,-10);
        sistemaBiblioteca.nuevoLibro("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(1);
        sistemaBiblioteca.pedirPrestamo(13, 44517985, 2);
        
        

    }
}