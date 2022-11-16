package test;

import excepciones.*;
import modelos.Mesa;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class CrearComandaTest {
    private static Mesa mesa1 = new Mesa(2, 5);
    private static Mesa mesa2 = new Mesa(3, 5);


    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        }
        catch (SistemaYaInicializadoException e) {}

        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarMesa(mesa1);
            Sistema.getInstancia().agregarMesa(mesa2);
        }
        catch (MesaRepetidaException e) {}
        catch (OperacionNoAutorizadaException e) {}



    }

    @Test
    public void datosCorrectosTest() {

        try {
            Sistema.getInstancia().crearComanda(mesa1);
        } catch (MesaOcupadaException e) {
            fail("Mesa no deberia estar ocupada");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        }
    }

    @Test
    public void mesaOcupadaTest() {
        mesa2.ocupar();
        try {
            Sistema.getInstancia().crearComanda(mesa2);
            fail("Mesa deberia estar ocupada");
        } catch (MesaOcupadaException e) {
            System.out.println("Mesa ocupada");
        } catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        }
    }

    @Test
    public void mesaInexistenteTest() {
        try {
            Sistema.getInstancia().crearComanda(new Mesa(4, 4));
            fail("Mesa deberia estar inexistente");
        } catch (MesaOcupadaException e) {
            fail("Mesa no deberia estar ocupada");
        } catch (MesaInexistenteException e) {
            System.out.println("Mesa inexistente");
        }
    }
}
