package test;

import excepciones.*;
import modelos.Producto;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class EliminarProductoTest {

    private static Producto producto = new Producto("Papas", 100, 150, 20);


    @BeforeAll
    public static void setUp() {
        Escenario.setUp();
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarProducto(producto);
        }
        catch (ProductoExistenteException e) {}
        catch (OperacionNoAutorizadaException e) {}
    }
    @AfterAll
    public static void tearDown() {
        Escenario.resetearSistema();
    }

    @AfterEach
    public void tearDownEach() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarProducto(producto);
        } catch (ProductoExistenteException e) {
        } catch (OperacionNoAutorizadaException e) {
        }
    }

    @Test
    public void datosCorrectosTest() {
        try {
            Sistema.getInstancia().eliminarProducto(producto);
            System.out.println("Producto eliminado");
        }
        catch (OperacionNoAutorizadaException e) {
            fail("Operacion deberia estar autorizada");
        } catch (ProductoInexistenteException e) {
            fail("Producto deberia existir");
        } catch (ProductoEnComandaException e) {
            fail("Producto no deberia estar en comanda");
        }
    }

    @Test
    public void productoInexistenteException() {
        Producto producto1 = new Producto("Hamburguesa", 100, 150, 20);
        try {
            Sistema.getInstancia().eliminarProducto(producto1);
            fail("Deberia haber excepcion");
        }
        catch (OperacionNoAutorizadaException e) {
            fail("Operacion deberia estar autorizada");
        } catch (ProductoInexistenteException e) {
            System.out.println("Producto inexistente");
        } catch (ProductoEnComandaException e) {
            fail("Producto no deberia estar en comanda");
        }
    }

    @Test
    public void productoEnComandaException() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
        try {
            Sistema.getInstancia().eliminarProducto(producto);
            fail("Deberia haber excepcion");
        }
        catch (OperacionNoAutorizadaException e) {
            fail("Operacion deberia estar autorizada");
        } catch (ProductoInexistenteException e) {
            fail("Producto deberia existir");
        } catch (ProductoEnComandaException e) {
            System.out.println("Producto en comanda");
        }
    }

    @Test
    public void operacionNoAutorizadaException() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
        try {
            Sistema.getInstancia().eliminarProducto(producto);
            fail("Deberia haber excepcion");
        }
        catch (OperacionNoAutorizadaException e) {
            System.out.println("Operacion no autorizada");
        } catch (ProductoInexistenteException e) {
            fail("Producto deberia existir");
        } catch (ProductoEnComandaException e) {
            fail("Producto no deberia estar en comanda");
        }
    }
}
