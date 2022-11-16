package test;

import excepciones.*;
import modelos.Mesa;
import modelos.Mozo;
import modelos.Sistema;
import modelos.Sueldo;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class AsignarMesaTest {
    private static Mesa mesa = new Mesa(2, 5);
    private static Sueldo sueldo = new Sueldo(500);
    private static Mozo mozo = new Mozo("Juan", "Perez", new Date(13/10/98), 2, sueldo);

    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        }
        catch (SistemaYaInicializadoException e) {}
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        try {
            Sistema.getInstancia().agregarMesa(mesa);
        }
        catch (MesaRepetidaException e) {}
        catch (OperacionNoAutorizadaException e) {}
        try {
            Sistema.getInstancia().agregarMozo(mozo);
        }
        catch (MozoExistenteException e) {}
        catch (MaximaCantidadMozosException e) {}
        catch (OperacionNoAutorizadaException e) {}


    }

    @Test
    public void datosCorrectosTest() throws MesaRepetidaException, OperacionNoAutorizadaException {
        try {
            Sistema.getInstancia().asignarMesa(mozo, mesa);
        }
        catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        }
        catch (MozoInexistenteException e) {
            fail("Mozo no deberia estar inexistente");
        }
    }

    @Test
    public void mesaInexistenteTest() {
        Mesa mesa2 = new Mesa(4, 4);
        try {
            Sistema.getInstancia().asignarMesa(mozo, mesa2);
            fail("Mesa deberia estar inexistente");
        }
        catch (MesaInexistenteException e) {
            System.out.println("Mesa inexistente");
        }
        catch (MozoInexistenteException e) {
            fail("Mozo no deberia estar inexistente");
        }
    }

    @Test
    public void mozoInexistenteTest() {
        Mozo mozo2 = new Mozo("Matias", "Perez", new Date(13/10/01), 1, sueldo);
        try {
            Sistema.getInstancia().asignarMesa(mozo2, mesa);
            fail("Mozo deberia estar inexistente");
        }
        catch (MesaInexistenteException e) {
            fail("Mesa no deberia estar inexistente");
        }
        catch (MozoInexistenteException e) {
            System.out.println("Mozo inexistente");
        }
    }

}
