package test;

import modelo.Mesa;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AgregarMesaTest {
    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void mesaAgregada() {
        Mesa mesa2 = new Mesa(2, 4);
        try {
            Sistema.getInstance().agregarMesa(mesa2);
            assertTrue("La mesa deberia haberse agregado correctamente", Sistema.getInstance().getMesas().contains(mesa2));
        } catch (Exception e) {
            fail("La mesa deberia haberse agregado correctamente");
        }
    }

    @Test
    void mesaYaExistente() {
        try {
            Sistema.getInstance().agregarMesa(Escenario1Sistema.getMesa1());
            fail("La mesa ya existe");
        } catch (Exception e) {

        }
    }
}
