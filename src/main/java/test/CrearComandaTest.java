package test;

import excepciones.*;
import modelo.Mesa;
import modelo.Producto;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class CrearComandaTest {

    private static Sistema sistema;

    @BeforeEach
    void setUp() {
        Escenario1Sistema.setUp();
        sistema = Sistema.getInstance();
    }

    @AfterEach
    void tearDown() {
        Escenario1Sistema.tearDown();
    }


    @Test
    void crearComanda() {
        try {
            Mesa mesa3 = Escenario1Sistema.getMesa3();
            Producto cocaCola = Escenario1Sistema.getProductoCocaCola();
            sistema.crearComanda(mesa3, cocaCola, 3);
            assertTrue(sistema.getComandas().containsKey(mesa3), "La comanda deberia haberse creado");
        } catch (ProductoNoDisponibleException | ProductoNoExisteException | MesaNoDisponibleException |
                 MesaNoExisteException |
                 CantidadEnPromocionMenorException e) {
            fail("No deberia haber lanzado ninguna excepcion");
        }
    }

    @Test
    void productoNoDisponible() {
        try {
            Mesa mesa3 = Escenario1Sistema.getMesa3();
            Producto cocaCola = Escenario1Sistema.getProductoCocaCola();
            sistema.crearComanda(mesa3, cocaCola, 50);
            fail("No deberia haberse creado la comanda");
        } catch (ProductoNoDisponibleException e) {

        } catch (ProductoNoExisteException | MesaNoDisponibleException | MesaNoExisteException |
                 CantidadEnPromocionMenorException e) {
            fail("El producto no deberia estar disponible");
        }
    }

    @Test
    void productoNoExistente() {
        try {
            Mesa mesa3 = Escenario1Sistema.getMesa3();
            Producto pepsi = new Producto(1, "Pepsi", 100, 200, 50);
            sistema.crearComanda(mesa3, pepsi, 3);
            fail("No deberia haberse creado la comanda");
        } catch (ProductoNoExisteException e) {

        } catch (ProductoNoDisponibleException | MesaNoDisponibleException | MesaNoExisteException |
                 CantidadEnPromocionMenorException e) {
            fail("El producto no deberia existir");
        }
    }

    @Test
    void mesaNoDisponible() {
        try {
            Mesa mesa1 = Escenario1Sistema.getMesa1();
            Producto cocaCola = Escenario1Sistema.getProductoCocaCola();
            sistema.crearComanda(mesa1, cocaCola, 3);
            fail("No deberia haberse creado la comanda");
        } catch (MesaNoDisponibleException e) {

        } catch (ProductoNoDisponibleException | ProductoNoExisteException | MesaNoExisteException |
                 CantidadEnPromocionMenorException e) {
            fail("La mesa no deberia estar disponible");
        }
    }

    @Test
    void MesaNoExistente() {
        try {
            Mesa mesa2 = new Mesa(2, 10);
            Producto cocaCola = Escenario1Sistema.getProductoCocaCola();
            sistema.crearComanda(mesa2, cocaCola, 3);
            fail("No deberia haberse creado la comanda");
        } catch (MesaNoExisteException e) {

        } catch (ProductoNoDisponibleException | ProductoNoExisteException | MesaNoDisponibleException |
                 CantidadEnPromocionMenorException e) {
            fail("La mesa no deberia existir");
        }
    }
}