package main.Facade;


import main.prestamo.Calendario;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    }

    @Test
    public void testNuevoRevistaEspecializada() {
    }

    @Test
    public void testNuevoDiario() {
    }

    @Test
    public void testNuevoLibro() {
    }

    @Test
    public void testNuevoRevista() {
    }

    @Test
    public void testPedirPrestamo() {
    }

    @Test
    public void testBuscarEjemplar() {
    }

    @Test
    public void testDevolverPrestamo() {
    }
}