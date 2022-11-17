package test;

import excepciones.*;
import modelos.Mesa;
import modelos.Pedido;
import modelos.Producto;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

public class EliminarProductoTest {

    private static Producto producto = new Producto("Papas", 100, 150, 20);


    @BeforeEach
    public void setUp() {
        Escenario.setUp();
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarProducto(producto);
        }
        catch (ProductoExistenteException e) {}
        catch (OperacionNoAutorizadaException e) {}
    }

    @AfterEach
    public void tearDownEach() {
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
    public void productoEnComandaException() throws MesaOcupadaException, MesaInexistenteException, StockInsuficienteException, ComandaInexistenteException, MesaRepetidaException, OperacionNoAutorizadaException {
        Mesa mesa = new Mesa(1, 5);
        Sistema.getInstancia().agregarMesa(mesa);
        Sistema.getInstancia().crearComanda(mesa);
        Pedido pedido = new Pedido(producto, 5);
        Sistema.getInstancia().agregarPedido(mesa, pedido);
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
