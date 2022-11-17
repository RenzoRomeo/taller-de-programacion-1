package test;

import excepciones.SistemaYaInicializadoException;
import modelos.Administrador;
import modelos.Sistema;

import java.util.ArrayList;
import java.util.HashMap;

public class Escenario {
    public static void resetearSistema(){
              if (Sistema.getInstancia().getAdministrador() != null) {
                  Sistema.getInstancia().getAdministrador().setInicializado(false);
                  Sistema.getInstancia().setAdministrador(null);
              }
            Sistema.getInstancia().setInstancia(null);
    }

    public static void setUp(){
        try {
            Sistema.inicializarSistema("McDonalds");
        }
        catch (SistemaYaInicializadoException e) {}

    }
}
