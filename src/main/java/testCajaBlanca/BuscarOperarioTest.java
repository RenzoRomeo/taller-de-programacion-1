package testCajaBlanca;

import excepciones.OperacionNoAutorizadaException;
import excepciones.OperarioExistenteException;
import excepciones.OperarioInexistenteException;
import modelos.Operario;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Escenario;

import static org.junit.jupiter.api.Assertions.fail;

public class BuscarOperarioTest {

    @BeforeEach
    public void setUp() {
        Escenario.setUp();
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
    }

    @AfterEach
    public void tearDown() {
        Escenario.resetearSistema();
    }

    @Test
    public void camino1() throws OperarioExistenteException, OperacionNoAutorizadaException {
        //Lista de operarios no vacia, nombre de usuario perteneciente a un operario
        Operario operario = new Operario("Juan", "Perez", "jperez", "Jper1234");
        Sistema.getInstancia().agregarOperario(operario);
        try {
            Assertions.assertEquals(operario, BuscarOperarioCobertura.buscarOperario("jperez"), "El operario no es el mismo");
            System.out.println("Operario encontrado");
        } catch (OperarioInexistenteException e) {
            fail("Debio encontrar el operario");
        }
    }

    @Test
    public void camino2(){
        //Lista de operarios vacia, nombre de usuario perteneciente al administrador
        try {
            BuscarOperarioCobertura.buscarOperario("ADMIN");
            System.out.println("Admin encontrado");
        } catch (OperarioInexistenteException e) {
            fail("Debio encontrar un administrador");
        }
    }

    @Test
    public void camino3(){
        //Lista de operarios vacia, nombre de usuario no perteneciente al administrador
        try {
            BuscarOperarioCobertura.buscarOperario("jperez");
            fail("No deberia encontrar un operario");
        } catch (OperarioInexistenteException e) {
            System.out.println("Operario inexistente");
        }
    }
}
