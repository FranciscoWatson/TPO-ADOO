package main.Facade;


import main.prestamo.Calendario;
import main.socio.Suspendido;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SistemaBibliotecaTest {
    @Test
    public void testNuevoSocio() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        assertNotNull( sistemaBiblioteca.obtenerSocioController().obtenerSocio(12354698));
    }
    @Test
    public void testDosNuevosSocios() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoSocio(2, "MeVan", "ASuspender", 44517985, "elbaneado@gmail.com", 111522002,-10);
        assertNotNull( sistemaBiblioteca.obtenerSocioController().obtenerSocio(12354698));
        assertNotNull( sistemaBiblioteca.obtenerSocioController().obtenerSocio(44517985));

    }


    @Test
    public void testNuevoSocioConPlusDays() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoSocio(2, "MeVan", "ASuspender", 44517985, "elbaneado@gmail.com", 111522002,-10);
        assertTrue( sistemaBiblioteca.obtenerSocioController().obtenerSocio(44517985).obtenerDiasHabiles() == -10 );
    }

    @Test
    public void testNuevoRevistaEspecializada() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoRevistaEspecializada("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.obtenerEjemplarControler().obtenerEjemplar(1) );
    }

    @Test
    public void testNuevoDiario() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoDiario("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.obtenerEjemplarControler().obtenerEjemplar(1) );

    }

    @Test
    public void testNuevoLibro() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoLibro("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.obtenerEjemplarControler().obtenerEjemplar(1) );

    }

    @Test
    public void testNuevoRevista() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoRevista("Harry Potter", "asd",2, LocalDate.of(2010,2,2), "accion", 1,1,1);
        assertNotNull( sistemaBiblioteca.obtenerEjemplarControler().obtenerEjemplar(1) );
    }

    @Test
    public void testPedirPrestamo() {
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoSocio(1, "Juan", "Perez", 12354698, "juanperez@gmail.com", 13235686);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        sistemaBiblioteca.pedirPrestamo(1, 12354698, 1);
        assertNotNull( sistemaBiblioteca.obtenerPrestamoController().obtenerPrestamo(1));
    }

    @Test
    public void testBuscarEjemplar() {
    }

    @Test
    public void testDevolverPrestamo() {
        // Devolver prestamo pasado los 10 dias de vencimiento
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
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
        assertEquals(Suspendido.class, sistemaBiblioteca.obtenerSocioController().obtenerSocio(12354698).obtenerEstado().getClass());
    }
    @Test
    public void TestBuscarUbicacion(){
        Calendario calendario = new Calendario();
        SistemaBiblioteca sistemaBiblioteca = new SistemaBiblioteca(calendario);
        sistemaBiblioteca.nuevoLibro("El señol de los anillos", "Jose", 3, LocalDate.of(2023, 11, 16), "accion", 1,2,2);
        assertEquals(Arrays.asList(2, 2), sistemaBiblioteca.buscarUbicacion(1));
    }
}