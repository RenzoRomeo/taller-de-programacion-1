package test;

import excepciones.UsuarioNoExisteException;
import modelo.Operario;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import static org.junit.Assert.fail;

public class EliminarOperarioTest {
    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void operarioEliminado() {
        Operario juan = Escenario1Sistema.getJuan();
        try {
            Sistema.getInstance().eliminarOperario(juan);
        } catch (UsuarioNoExisteException e) {
            fail("El operario deberia haberse eliminado correctamente");
        }
    }

    @Test
    void operarioInexistente() {
        Operario esteban = new Operario("Esteban", "Perez", "Esteban", "Esteban123");
        try {
            Sistema.getInstance().eliminarOperario(esteban);
            fail("El operario no deberia existir");
        } catch (UsuarioNoExisteException e) {

        }
    }
}
