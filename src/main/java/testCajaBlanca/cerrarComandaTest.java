package testCajaBlanca;

import excepciones.*;
import modelos.Mesa;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Escenario;

import static org.junit.jupiter.api.Assertions.fail;

public class cerrarComandaTest {

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
    public void camino1() throws MesaRepetidaException, OperacionNoAutorizadaException { //mesa no esta en la coleccion de mesas del sistema
        Mesa mesa = new Mesa(1, 4);
        Mesa mesa1 = new Mesa(2, 4);
        Mesa mesa2 = new Mesa(3, 4);
        Sistema.getInstancia().agregarMesa(mesa);
        Sistema.getInstancia().agregarMesa(mesa1);

        try {
            Sistema.getInstancia().cerrarComanda(mesa2);
            fail("Debio lanzar excepcion de mesa no encontrada");
        } catch (MesaInexistenteException e) {
            System.out.println("Mesa inexistente");
        } catch (MesaNoOcupadaException e) {
            fail("Mesa no deberia estar ocupada");
        }
    }

    @Test
    public void camino2() throws MesaRepetidaException, OperacionNoAutorizadaException {
        //mesa esta en la coleccion de mesas del sistema pero no esta ocupada
        Mesa mesa = new Mesa(1, 4);
        Sistema.getInstancia().agregarMesa(mesa);

        try {
            Sistema.getInstancia().cerrarComanda(mesa);
            fail("Debio lanzar excepcion de mesa no encontrada");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        } catch (MesaNoOcupadaException e) {
            System.out.println("Mesa no ocupada");
        }
    }

    @Test
    public void camino3() throws MesaRepetidaException, OperacionNoAutorizadaException {
        //mesa esta en la coleccion de mesas del sistema y esta ocupada pero no hay comandas cargadas en el sistema asi que no sucede nada
        Mesa mesa = new Mesa(1, 4);
        Sistema.getInstancia().agregarMesa(mesa);
        mesa.ocupar();
        try {
            Sistema.getInstancia().cerrarComanda(mesa);
            System.out.println("No hay comandas cargadas en el sistema, no sucede nada ya que no es camino posible, si esta ocupada la mesa es porque hay comanda creada");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        } catch (MesaNoOcupadaException e) {
            fail("Mesa no deberia estar no ocupada");
        }
    }

    @Test
    public void camino4() throws MesaRepetidaException, OperacionNoAutorizadaException, MesaOcupadaException, MesaInexistenteException {
        //mesa esta en la coleccion de mesas del sistema y esta ocupada y hay comandas cargadas en el sistema
        Mesa mesa = new Mesa(1, 4);
        Mesa mesa1 = new Mesa(2, 4);
        Sistema.getInstancia().agregarMesa(mesa);
        Sistema.getInstancia().agregarMesa(mesa1);
        mesa.ocupar();
        Sistema.getInstancia().crearComanda(mesa1);
        try {
            Sistema.getInstancia().cerrarComanda(mesa);
            System.out.println("Comanda no existente para la mesa, camino no posible en el sistema");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        } catch (MesaNoOcupadaException e) {
            fail("Mesa no deberia estar no ocupada");
        }
    }

    @Test
    public void camino5() throws MesaRepetidaException, OperacionNoAutorizadaException, MesaOcupadaException, MesaInexistenteException {
        //mesa esta en la coleccion de mesas del sistema y esta ocupada y hay tiene comanda asignada a la mesa
        Mesa mesa = new Mesa(1, 4);
        Sistema.getInstancia().agregarMesa(mesa);
        Sistema.getInstancia().crearComanda(mesa);
        try {
            Sistema.getInstancia().cerrarComanda(mesa);
            System.out.println("Comanda existente para la mesa, camino posible en el sistema");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        } catch (MesaNoOcupadaException e) {
            fail("Mesa no deberia estar no ocupada");
        }
    }
}
