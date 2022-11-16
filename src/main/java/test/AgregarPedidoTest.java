package test;

import excepciones.MesaNoExisteException;
import excepciones.MesaNoTieneComandaException;
import excepciones.ProductoNoDisponibleException;
import excepciones.ProductoNoExisteException;
import modelo.Mesa;
import modelo.Producto;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AgregarPedidoTest {

    @BeforeAll
    static void setUp() {
        Escenario1Sistema.setUp();
    }

    @AfterAll
    static void tearDown() {
        Escenario1Sistema.tearDown();
    }

    @Test
    void agregarPedido() {
        try {
            AtomicInteger cantidadProductoAntes = new AtomicInteger();
            Sistema.getInstance().getComandas().get(Escenario1Sistema.getMesa1()).getPedidos().forEach(
                    pedido -> {
                        if (pedido.getProducto().equals(Escenario1Sistema.getProductoCocaCola())) {
                            cantidadProductoAntes.addAndGet(pedido.getCantidad());
                        }
                    }
            );

            Sistema.getInstance().agregarPedido(Escenario1Sistema.getProductoCocaCola(), 2, Escenario1Sistema.getMesa1());

            AtomicInteger cantidadProductoDespues = new AtomicInteger();
            Sistema.getInstance().getComandas().get(Escenario1Sistema.getMesa1()).getPedidos().forEach(
                    pedido -> {
                        if (pedido.getProducto().equals(Escenario1Sistema.getProductoCocaCola())) {
                            cantidadProductoDespues.addAndGet(pedido.getCantidad());
                        }
                    }
            );

            assertEquals("La cantidad de productos deberia haberse incrementado en 2", cantidadProductoAntes.get() + 2, cantidadProductoDespues.get());
        } catch (MesaNoTieneComandaException e) {
            fail("La mesa deberia tener una comanda");
        } catch (MesaNoExisteException e) {
            fail("La mesa deberia existir");
        } catch (ProductoNoDisponibleException e) {
            fail("El producto deberia estar disponible");
        } catch (ProductoNoExisteException e) {
            fail("El producto deberia existir");
        }
    }

    @Test
    void productoNoExiste() {
        Producto cerveza = new Producto(2, "Cerveza", 90, 110, 50);
        try {
            Sistema.getInstance().agregarPedido(cerveza, 2, Escenario1Sistema.getMesa1());
            fail("El producto no deberia existir");
        } catch (MesaNoTieneComandaException e) {
            fail("La mesa deberia tener una comanda");
        } catch (MesaNoExisteException e) {
            fail("La mesa deberia existir");
        } catch (ProductoNoDisponibleException e) {
            fail("El producto deberia estar disponible");
        } catch (ProductoNoExisteException e) {
        }
    }

    @Test
    void mesaNoExiste() {
        Mesa mesa2 = new Mesa(2, 2);
        try {
            Sistema.getInstance().agregarPedido(Escenario1Sistema.getProductoCocaCola(), 2, mesa2);
            fail("La mesa no deberia existir");
        } catch (MesaNoTieneComandaException e) {
            fail("La mesa deberia tener una comanda");
        } catch (MesaNoExisteException e) {
        } catch (ProductoNoDisponibleException e) {
            fail("El producto deberia estar disponible");
        } catch (ProductoNoExisteException e) {
            fail("El producto deberia existir");
        }
    }

    @Test
    void productoNoDisponible() {
        try {
            Sistema.getInstance().agregarPedido(Escenario1Sistema.getProductoCocaCola(), 300, Escenario1Sistema.getMesa1());
            fail("El producto no deberia estar disponible");
        } catch (MesaNoTieneComandaException e) {
            fail("La mesa deberia tener una comanda");
        } catch (MesaNoExisteException e) {
            fail("La mesa deberia existir");
        } catch (ProductoNoDisponibleException e) {
        } catch (ProductoNoExisteException e) {
            fail("El producto deberia existir");
        }
    }

    @Test
    void mesaNoTieneComanda() {
        try {
            Sistema.getInstance().agregarPedido(Escenario1Sistema.getProductoCocaCola(), 2, Escenario1Sistema.getMesa3());
            fail("La mesa no deberia tener una comanda");
        } catch (MesaNoTieneComandaException e) {

        } catch (MesaNoExisteException e) {
            fail("La mesa deberia tener una comanda abierta");
        } catch (ProductoNoDisponibleException e) {
            fail("La mesa deberia tener una comanda abierta");
        } catch (ProductoNoExisteException e) {
            fail("La mesa deberia tener una comanda abierta");
        }
    }
}
