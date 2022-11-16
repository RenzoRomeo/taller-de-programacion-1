package test.escenarios;

import enums.Dia;
import excepciones.*;
import modelo.*;

import java.util.ArrayList;
import java.util.Date;

public class Escenario1Sistema {
    private static Operario operarioJuan;
    private static Operario operarioJose;
    private static Mozo mozoAlberto;
    private static Mesa mesa1;
    private static Mesa mesa3;
    private static Producto productoCocaCola;

    public static void setUp() {
        Sistema sistema = Sistema.getInstance();
        operarioJuan = new Operario("Juan", "Perez", "Juan", "Juan123");
        operarioJose = new Operario("Jose", "Perez", "Jose", "Jose123");
        operarioJose.setActivo(false);

        mozoAlberto = new Mozo("Alberto", "Perez", new Date(1995, 5, 10), 0);

        mesa1 = new Mesa(1, 4);
        mesa3 = new Mesa(3, 4);

        productoCocaCola = new Producto(1, "Coca Cola", 80, 100, 50);

        ArrayList<Dia> dias = new ArrayList<>();
        dias.add(Dia.LUNES);
        dias.add(Dia.MARTES);
        dias.add(Dia.MIERCOLES);
        dias.add(Dia.JUEVES);
        dias.add(Dia.VIERNES);
        dias.add(Dia.SABADO);
        dias.add(Dia.DOMINGO);

        try {
            sistema.agregarOperario(operarioJuan);
            sistema.agregarOperario(operarioJose);
            sistema.agregarMozo(mozoAlberto);
            sistema.agregarMesa(mesa1);
            sistema.agregarMesa(mesa3);
            sistema.agregarProducto(productoCocaCola);
            sistema.asignarMesa(mozoAlberto, mesa1);
            sistema.agregarPromocionProducto(1, true, dias, productoCocaCola, true, false, 0, 0);
            sistema.agregarPromocionProducto(2, true, dias, productoCocaCola, false, true, 4, 20);
            sistema.crearComanda(mesa1, productoCocaCola, 1);
        } catch (NombreDeUsuarioNoDisponibleException | MozoYaExistenteException | MesaYaExistenteException |
                 ProductoYaExistenteException | MesaNoExisteException | MesaNoDisponibleException |
                 ProductoNoExisteException | ProductoNoDisponibleException | CantidadEnPromocionMenorException |
                 MozoNoExisteException | MozoNoActivoException e) {
            e.printStackTrace();
        }
    }

    public static void tearDown() {
        Sistema sistema = Sistema.getInstance();
        sistema.getOperarios().clear();
        sistema.getMozos().clear();
        sistema.getMesas().clear();
        sistema.getProductos().clear();
        sistema.getComandas().clear();
        sistema.getPromocionesProducto().clear();
    }

    public static Operario getOperarioJuan() {
        return operarioJuan;
    }

    public static Operario getOperarioJose() {
        return operarioJose;
    }

    public static Mozo getMozoAlberto() {
        return mozoAlberto;
    }

    public static Mesa getMesa1() {
        return mesa1;
    }

    public static Mesa getMesa3() {
        return mesa3;
    }

    public static Producto getProductoCocaCola() {
        return productoCocaCola;
    }
}
