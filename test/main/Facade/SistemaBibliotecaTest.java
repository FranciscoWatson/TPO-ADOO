package main.Facade;


import main.prestamo.observer.Calendario;
import main.socio.estadoSocio.Habilitado;
import main.socio.estadoSocio.Suspendido;
import main.socio.estrategiaNotificacion.NotificacionEmail;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SistemaBibliotecaTest {
    Calendario calendario = new Calendario();
    SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
    @Test
    public void testNuevoSocio() {

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        assertNotNull( sistemaBiblioteca.getSocioController().getSocio(12354698));
    }
    @Test
    public void testDosNuevosSocios() {

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoSocio(2, "MeVan", "ASuspender", 44517985, "elbaneado@gmail.com", 111522002,-10);
        assertNotNull( sistemaBiblioteca.getSocioController().getSocio(12354698));
        assertNotNull( sistemaBiblioteca.getSocioController().getSocio(44517985));

    }
    
    @Test
    public void testModificarSocioYverDatalog() {
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.cambiarApellidoSocio(1, "Jackson", 12354698);
        sistemaBiblioteca.cambiarNombreSocio(1, "Jorgue", 12354698);
        sistemaBiblioteca.cambiarMail(2, "jjackson@gmail.com", 12354698);
        sistemaBiblioteca.getModificaciones(12354698);

    }


    @Test
    public void testNuevoSocioConPlusDays() {

        sistemaBiblioteca.nuevoSocio(2, "MeVan", "ASuspender", 44517985, "elbaneado@gmail.com", 111522002,-10);
        assertTrue( sistemaBiblioteca.getSocioController().getSocio(44517985).getDiasHabiles() == -10 );
    }

    @Test
    public void testNuevoRevistaEspecializada() {

        sistemaBiblioteca.nuevoRevistaEspecializada("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.getEjemplarController().getEjemplar(1) );
    }

    @Test
    public void testNuevoDiario() {

        sistemaBiblioteca.nuevoDiario("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.getEjemplarController().getEjemplar(1) );

    }

    @Test
    public void testNuevoLibro() {

        sistemaBiblioteca.nuevoLibro("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.getEjemplarController().getEjemplar(1) );

    }

    @Test
    public void testNuevoRevista() {

        sistemaBiblioteca.nuevoRevista("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.getEjemplarController().getEjemplar(1) );
    }

    @Test
    public void testPedirPrestamo() {

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        assertNotNull( sistemaBiblioteca.getPrestamoController().getPrestamo(1));
    }
    
    @Test
    public void testVerHistorial() {

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.nuevoRevista("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 2,1,1);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 2);
        sistemaBiblioteca.verHistorialPrestamo(12354698);
    }
    
    @Test
    public void testAgregarDiasPrestamo() {
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        LocalDate fechaActual = LocalDate.now();
        fechaActual = fechaActual.plusDays(3);
        assertEquals(fechaActual, sistemaBiblioteca.getPrestamoController().getFechaVec(1));
        sistemaBiblioteca.agregarDiasPrestamo(10, 1);
        fechaActual = fechaActual.plusDays(10);
        assertEquals(fechaActual, sistemaBiblioteca.getPrestamoController().getFechaVec(1));
    }

    @Test
    public void testBuscarEjemplar() {
    	sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "Fantasia", 1,2,2);
    	sistemaBiblioteca.nuevoLibro("Luna de Pluton", "Chiqui tapia", 3, LocalDate.of(2023, 11, 16), "Ciencia Ficcion", 2,2,2);
    	sistemaBiblioteca.nuevoLibro("El hobbit", "Jose", 3, LocalDate.of(2023, 11, 16), "Fantasia",3,2,2);
    	sistemaBiblioteca.buscarEjemplar("Fantasia");
    }

    @Test
    public void testDevolverPrestamoFueraDeTermino() {
        // Devolver prestamo pasado los 10 dias de vencimiento

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(1);
        assertEquals(Suspendido.class, sistemaBiblioteca.getSocioController().getSocio(12354698).getEstado().getClass());
    }
    @Test
    public void testDevolver5PrestamoEnTerminoSuma1DiaExtra() {
        // Devolver 5 Prestamos suma 1 dia extra para los siguientes prestamos

        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(1);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(3);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(4);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        calendario.cambioDia();
        sistemaBiblioteca.devolverPrestamo(5);
        assertEquals(1, sistemaBiblioteca.getSocioController().getSocio(12354698).getDiasHabiles());
    }

    @Test
    public void TestCambiarEstrategiaNotificacion() {
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.cambiarEstrategiaNotificacion(1,12354698, "email" );
        assertEquals(NotificacionEmail.class, sistemaBiblioteca.getSocioController().getSocio(12354698).getNotificacion().getClass());

    }


    @Test
    public void TestBuscarUbicacion(){
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        assertEquals(Arrays.asList(2, 2), sistemaBiblioteca.buscarUbicacion(1));
    }
}