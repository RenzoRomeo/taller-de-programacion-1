package test;

import excepciones.SistemaYaInicializadoException;
import modelos.Administrador;
import modelos.Sistema;

import java.util.ArrayList;
import java.util.HashMap;

public class Escenario {
    public static void resetearSistema(){
//            if (Sistema.getInstancia().getModoOperacion() != null) {
//                Sistema.getInstancia().setModoOperacion(null);
//            }
//            if (Sistema.getInstancia().getMesas() != null) {
//                Sistema.getInstancia().setMesas(null);
//            }
//            if (Sistema.getInstancia().getProductos() != null) {
//                Sistema.getInstancia().setProductos(null);
//            }
//            if (Sistema.getInstancia().getPromocionesProducto() != null) {
//                Sistema.getInstancia().setPromocionesProducto(null);
//            }
//            if (Sistema.getInstancia().getPromocionesTemporales() != null) {
//                Sistema.getInstancia().setPromocionesTemporales(null);
//            }
//            if (Sistema.getInstancia().getOperarios() != null) {
//                Sistema.getInstancia().setOperarios(null);
//            }
//            if (Sistema.getInstancia().getComandas() != null) {
//                Sistema.getInstancia().setComandas(null);
//            }
//            if (Sistema.getInstancia().getNombreLocal() != null) {
//                Sistema.getInstancia().setNombreLocal(null);
//            }
//            if (Sistema.getInstancia().getAsignacionMesas() != null) {
//                Sistema.getInstancia().setAsignacionMesas(null);
//            }
//            if (Sistema.getInstancia().getMozos() != null) {
//                Sistema.getInstancia().setMozos(null);
//            }
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
