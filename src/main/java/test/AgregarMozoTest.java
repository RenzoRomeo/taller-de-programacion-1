package test;

import excepciones.MozoYaExistenteException;
import modelo.Mozo;
import modelo.Sistema;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import java.util.Date;

import static org.junit.Assert.fail;

public class AgregarMozoTest {

    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void mozoAgregado() {
        Mozo mozoAgregado = new Mozo("Rodrigo", "Perez", new Date(11, 10, 1990), 2);
        Assert.assertTrue("El mozo deberia haberse agregado correctamente", Sistema.getInstance().getMozos().contains(mozoAgregado));
        try {
            Sistema.getInstance().agregarMozo(mozoAgregado);
        } catch (MozoYaExistenteException e) {
            fail("El mozo deberia haberse agregado correctamente");
        }
    }

    @Test
    void mozoYaExistente() {
        Mozo mozoAgregado = new Mozo("Alberto", "Perez", new Date(17, 11, 1991), 1);
        try {
            Sistema.getInstance().agregarMozo(mozoAgregado);
            fail("El mozo ya existe");
        } catch (MozoYaExistenteException e) {

        }
    }
}
