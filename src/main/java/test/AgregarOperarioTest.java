package test;

import excepciones.OperacionNoAutorizadaException;
import excepciones.OperarioExistenteException;
import excepciones.SistemaYaInicializadoException;
import modelos.Operario;
import modelos.Sistema;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarOperarioTest {

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
    public void datosCorrectosTest(){
        Operario operario = new Operario("Teo", "Ramos", "teo1", "Teo1234");
        try {
            Sistema.getInstancia().agregarOperario(operario);
        } catch (OperarioExistenteException e) {
            fail("Operario no deberia existir");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        }
    }

    @Test
    public void operarioExistenteTest(){
        Operario operario = new Operario("Teo", "Ramos", "teoramites", "Teo1234");
        try {
            Sistema.getInstancia().agregarOperario(operario);
            Sistema.getInstancia().agregarOperario(operario);
            fail("Debio lanzar excepcion de operario existente");
        } catch (OperarioExistenteException e) {
            System.out.println("Operario existente");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        }
    }

    @Test
    public void operacionNoAutorizadaTest(){
        Operario operario = new Operario("Teo", "Ramos", "teo2", "Teo1234");
        Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
        try {
            Sistema.getInstancia().agregarOperario(operario);
            fail("Debio lanzar excepcion de operacion no autorizada");
        } catch (OperarioExistenteException e) {
            fail("Operario no deberia existir");
        } catch (OperacionNoAutorizadaException e) {
            System.out.println("Operacion no autorizada");
        }
    }
}

