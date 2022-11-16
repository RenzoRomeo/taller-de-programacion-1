package test;

import excepciones.*;
import modelos.Mesa;
import modelos.Pedido;
import modelos.Producto;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarPedidoTest {
    private static Mesa mesa = new Mesa(0, 1);
    private static Producto burger = new Producto("Hamburguesa", 80, 100, 10);


    @BeforeAll
    public static void setUp() {
        Escenario.setUp();
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
    }
    @AfterAll
    public static void tearDown() {
        Escenario.resetearSistema();
    }

    @Test
    public void datosCorrectosTest() {
        Pedido pedido = new Pedido(burger, 5);
        try {
            Sistema.getInstancia().crearComanda(mesa);
        }
        catch (MesaInexistenteException e) {}
        catch (MesaOcupadaException e) {}
        try {
            Sistema.getInstancia().agregarPedido(mesa, pedido);
        } catch (StockInsuficienteException e) {
            fail("Stock deberia ser suficiente");
        } catch (ComandaInexistenteException e) {
            fail("Comanda deberia existir");
        }
    }

    @Test
    public void mesaSinComandaTest() {
        Pedido pedido = new Pedido(burger, 5);
        try {
            Sistema.getInstancia().agregarPedido(mesa, pedido);
            fail("Comanda no deberia existir");
        } catch (StockInsuficienteException e) {
            fail("Stock deberia ser suficiente");
        } catch (ComandaInexistenteException e) {
            System.out.println("Comanda no existe");
        }
    }

    @Test
    public void stockInsuficienteTest() {
        Pedido pedido = new Pedido(burger, 15);
        try {
            Sistema.getInstancia().crearComanda(mesa);
        }
        catch (MesaInexistenteException e) {}
        catch (MesaOcupadaException e) {}
        try {
            Sistema.getInstancia().agregarPedido(mesa, pedido);
            fail("Stock no deberia ser suficiente");
        } catch (StockInsuficienteException e) {
            System.out.println("Stock insuficiente");
        } catch (ComandaInexistenteException e) {
            fail("Comanda deberia existir");
        }
    }
}
