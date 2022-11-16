package test;

import excepciones.OperacionNoAutorizadaException;
import excepciones.ProductoExistenteException;
import excepciones.SistemaYaInicializadoException;
import modelos.Producto;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarProductoTest {

    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        } catch (SistemaYaInicializadoException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void datosCorrectosTest() {
        Producto producto = new Producto("Papas", 100, 150, 20);
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarProducto(producto);
        } catch (ProductoExistenteException e) {
            fail("Producto no deberia existir");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion deberia estar autorizada");
        }
    }

    @Test
    public void productoExistenteException() {
        Producto producto = new Producto("Papas", 100, 150, 20);
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarProducto(producto);
            Sistema.getInstancia().agregarProducto(producto);
            fail("Deberia haber excepcion");
        } catch (ProductoExistenteException e) {
            System.out.println("Producto existente");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion deberia estar autorizada");
        }
    }

    @Test
    public void operacionNoAutorizadaException() {
        Producto producto = new Producto("Papas", 100, 150, 20);
        Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
        try {
            Sistema.getInstancia().agregarProducto(producto);
            fail("Deberia haber excepcion");
        } catch (ProductoExistenteException e) {
            fail("Producto no deberia existir");
        } catch (OperacionNoAutorizadaException e) {
            System.out.println("Operacion no autorizada");
        }
    }
}
