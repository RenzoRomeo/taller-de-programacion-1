package test;

import excepciones.MaximaCantidadMozosException;
import excepciones.MozoExistenteException;
import excepciones.OperacionNoAutorizadaException;
import excepciones.SistemaYaInicializadoException;
import modelos.Mozo;
import modelos.Sistema;
import modelos.Sueldo;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarMozoTest {

    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        } catch (SistemaYaInicializadoException e) {
            fail("Sistema no deberia estar inicializado");
        }
    }

    @Test
    public void datosCorrectosTest() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        Date date = new Date(13/10/98);
        Sueldo sueldo = new Sueldo(1000);
        Mozo mozo = new Mozo("Juan", "Perez", date, 2, sueldo);
        try {
            Sistema.getInstancia().agregarMozo(mozo);
            System.out.println("Mozo agregado correctamente");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        } catch (MozoExistenteException e) {
            fail("Mozo no deberia existir");
        } catch (MaximaCantidadMozosException e) {
            fail("No deberia haber alcanzado el maximo de mozos");
        }
    }

    @Test
    public void agregarMozoExistenteTest() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        Date date = new Date(13/10/98);
        Sueldo sueldo = new Sueldo(1000);
        Mozo mozo = new Mozo("Juan", "Perez", date, 4, sueldo);
        try {
            Sistema.getInstancia().agregarMozo(mozo);
            Sistema.getInstancia().agregarMozo(mozo);
            fail("Debio lanzar excepcion de mozo existente");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        } catch (MozoExistenteException e) {
            System.out.println("Mozo existente");
        } catch (MaximaCantidadMozosException e) {
            fail("No deberia haber alcanzado el maximo de mozos");
        }
    }

    @Test
    public void agregarMozoSinAutorizacionTest() {
        Date date = new Date(13/10/98);
        Sueldo sueldo = new Sueldo(1000);
        Mozo mozo = new Mozo("Juan", "Perez", date, 4, sueldo);
        try {
            Sistema.getInstancia().setModoOperacion(ModoOperacion.OPERARIO);
            Sistema.getInstancia().agregarMozo(mozo);
            fail("Debio lanzar excepcion de operacion no autorizada");
        } catch (OperacionNoAutorizadaException e) {
            System.out.println("Operacion no autorizada");
        } catch (MozoExistenteException e) {
            fail("Mozo no deberia existir");
        } catch (MaximaCantidadMozosException e) {
            fail("No deberia haber alcanzado el maximo de mozos");
        }
    }

    @Test
    public void agregarMozoMaximoTest() {
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        Date date;
        Sueldo sueldo;
        Mozo mozo;
        try {
            for (int i = 0; i < 7; i++) {
                date = new Date(13/10/98);
                sueldo = new Sueldo(1000);
                mozo = new Mozo("Juan", "Perez", date, i+3, sueldo);
                Sistema.getInstancia().agregarMozo(mozo);
            }
            fail("Debio lanzar excepcion de maxima cantidad de mozos");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        } catch (MozoExistenteException e) {
            fail("Mozo no deberia existir");
        } catch (MaximaCantidadMozosException e) {
            System.out.println("Maxima cantidad de mozos alcanzada");
        }
    }
}
