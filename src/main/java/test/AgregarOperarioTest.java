package test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Operario;
import modelo.Sistema;
import test.escenarios.Escenario1Sistema;

class AgregarOperarioTest {

	private static Sistema sistema;
	
    @BeforeAll
    static void setUp() {
    	Escenario1Sistema.setUp();
        sistema = Sistema.getInstance();
    }
    
    @AfterAll
    static void tearDown() {
    	Escenario1Sistema.tearDown();
    }

    @Test
    void operarioAgregado() {
        try {
        	Operario operarioAgregado = new Operario("Jorge", "Perez", "Jorge", "Jorge123");
            sistema.agregarOperario(operarioAgregado);
            Operario operarioSistema = sistema.getOperarios().get("Jorge");
            assertEquals(operarioAgregado, operarioSistema, "El operario deberia haberse agregado correctamente");
        } catch (NombreDeUsuarioNoDisponibleException e) {
            fail("El operario deberia haberse agregado correctamente");
        }
    }

    @Test
    void nombreDeUsuarioNoDisponible() {
        try {
            sistema.agregarOperario(new Operario("Juan Martin", "Fernandez", "Juan", "Password123"));
            fail("El nombre de usuario no deberia estar disponible");
        } catch (NombreDeUsuarioNoDisponibleException e) {

        }
    }

}