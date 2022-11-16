package test;

import enums.Estado;
import excepciones.EstadoMozoInvalidoException;
import excepciones.MozoNoExisteException;
import modelo.Mozo;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import java.util.Date;

import static org.junit.Assert.fail;

public class EstablecerEstadoMozoTest {

    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void establecerEstadoMozo() {
        try {
            Sistema.getInstance().establecerEstadoMozo(Escenario1Sistema.getMozoAlberto(), Estado.ACTIVO);
        } catch (MozoNoExisteException e) {
            fail("El mozo deberia existir");
        } catch (EstadoMozoInvalidoException e) {
            fail("El estado del mozo deberia ser valido");
        }
    }

    @Test
    void establecerEstadoMozoInexistente() {
        try {
            Sistema.getInstance().establecerEstadoMozo(new Mozo("Mario", "Thevenon", new Date(1990, 2, 23), 3), Estado.ACTIVO);
            fail("El mozo no deberia existir");
        } catch (MozoNoExisteException e) {

        } catch (EstadoMozoInvalidoException e) {
            fail("El estado del mozo deberia ser valido");
        }
    }
}
