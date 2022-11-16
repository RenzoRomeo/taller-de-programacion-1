package test;

import excepciones.*;
import modelos.*;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class Main {
    private static Mesa mesa = new Mesa(2, 5);
    private static Sueldo sueldo = new Sueldo(500);
    private static Mozo mozo = new Mozo("Juan", "Perez", new Date(13/10/98), 2, sueldo);
    public static void main(String[] args) throws SistemaYaInicializadoException, OperarioExistenteException, OperacionNoAutorizadaException, MesaRepetidaException, MozoExistenteException, MaximaCantidadMozosException, MozoInexistenteException, MesaInexistenteException {
        Sistema.inicializarSistema("McDonalds");
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        Sistema.getInstancia().agregarMozo(mozo);
        Sistema.getInstancia().agregarMesa(mesa);
        Sistema.getInstancia().asignarMesa(mozo, mesa);
    }
}
