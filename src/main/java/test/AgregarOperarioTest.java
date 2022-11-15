package test;

import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Operario;
import modelo.Sistema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class AgregarOperarioTest {
    private static Sistema sistema;

    @BeforeAll
    static void setUp() {
        sistema = Sistema.getInstance();
    }

    @Test
    void operarioAgregado() {
        try {
            sistema.agregarOperario(new Operario("Juan", "Perez", "Juan", "Juan123"));
        } catch (NombreDeUsuarioNoDisponibleException e) {
            fail("El operario deberia haberse agregado correctamente");
        }
    }

    @Test
    void nombreDeUsuarioNoDisponible() {
        try {
            sistema.agregarOperario(new Operario("Jose", "Perez", "Jose", "Jose123"));
            sistema.agregarOperario(new Operario("Jose", "Perez", "Jose", "Jose123"));
            fail("El nombre de usuario no deberia estar disponible");
        } catch (NombreDeUsuarioNoDisponibleException e) {

        }
    }

}