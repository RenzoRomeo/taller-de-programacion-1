package test;

import static org.junit.jupiter.api.Assertions.*;
import excepciones.MesaRepetidaException;
import excepciones.OperacionNoAutorizadaException;
import excepciones.SistemaYaInicializadoException;
import modelos.Mesa;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarMesaTest {
    Mesa barra = new Mesa(0, 3);
    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        } catch (SistemaYaInicializadoException e) {
            fail("Sistema no deberia estar inicializado");
        }
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
    }

    @Test
    public void datosCorrectosTest() {
        Mesa mesa = new Mesa(2, 4);
        try {
            Sistema.getInstancia().agregarMesa(barra);
            Sistema.getInstancia().agregarMesa(mesa);
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        } catch (MesaRepetidaException e) {
            fail("Mesa no deberia existir");
        }
    }

    @Test
    public void agregarMesaRepetidaTest() {
        Mesa mesa = new Mesa(1, 4);
        try {
            Sistema.getInstancia().agregarMesa(mesa);
            Sistema.getInstancia().agregarMesa(mesa);
            fail("Debio lanzar excepcion de mesa repetida");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        } catch (MesaRepetidaException e) {
            System.out.println("Mesa repetida");
        }
    }

    @Test
    public void agregarMesaSinAutorizacionTest() {
        Mesa mesa = new Mesa(1, 4);
        try {
            Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
            Sistema.getInstancia().agregarMesa(mesa);
            fail("Debio lanzar excepcion de operacion no autorizada");
        } catch (OperacionNoAutorizadaException e) {
            System.out.println("Operacion no autorizada");
        } catch (MesaRepetidaException e) {
            fail("Mesa no deberia existir");
        }
    }
}
