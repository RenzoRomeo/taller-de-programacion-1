package test;

import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Operario;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import static org.junit.jupiter.api.Assertions.fail;

class AgregarOperarioTest {

    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void operarioAgregado() {
        try {
            Sistema.getInstance().agregarOperario(new Operario("Esteban", "Rodriguez", "Esteban", "Esteban123"));
        } catch (NombreDeUsuarioNoDisponibleException e) {
            fail("El operario deberia haberse agregado correctamente");
        }
    }

    @Test
    void nombreDeUsuarioNoDisponible() {
        try {
            Sistema.getInstance().agregarOperario(new Operario("Jose", "Perez", "Jose", "Jose123"));
            Sistema.getInstance().agregarOperario(new Operario("Jose", "Perez", "Jose", "Jose123"));
            fail("El nombre de usuario no deberia estar disponible");
        } catch (NombreDeUsuarioNoDisponibleException e) {

        }
    }

}