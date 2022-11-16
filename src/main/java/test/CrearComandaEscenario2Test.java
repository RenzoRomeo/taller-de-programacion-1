package test;

import excepciones.*;
import modelo.Mesa;
import modelo.Producto;
import modelo.Sistema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario2Sistema;

import static org.junit.jupiter.api.Assertions.fail;

class CrearComandaEscenario2Test {

    private Sistema sistema;

    @BeforeEach
    void setUp() {
        Escenario2Sistema.setUp();
        sistema = Sistema.getInstance();
    }

    @AfterEach
    void tearDown() {
        Escenario2Sistema.tearDown();
    }

    @Test
    void cantidadEnPromocion() {
        try {
            Mesa mesa3 = Escenario2Sistema.getMesa3();
            Producto cocaCola = Escenario2Sistema.getProductoCocaCola();
            sistema.crearComanda(mesa3, cocaCola, 3);
            fail("No deberia haberse creado la comanda");
        } catch (CantidadEnPromocionMenorException e) {

        } catch (ProductoNoExisteException | MesaNoDisponibleException | MesaNoExisteException |
                 ProductoNoDisponibleException e) {
            fail("La cantidad en promocion deberia ser mayor");
        }
    }
}