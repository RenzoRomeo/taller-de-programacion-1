package test.escenarios;

import excepciones.MesaYaExistenteException;
import excepciones.MozoYaExistenteException;
import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;

import java.util.Date;

public class Escenario1Sistema {
    private static Operario operarioJuan;
    private static Operario operarioJose;
    private static Mozo mozoAlberto;
    private static Mesa mesa1;

    public static void setUp() {
        Sistema sistema = Sistema.getInstance();
        operarioJuan = new Operario("Juan", "Perez", "Juan", "Juan123");
        operarioJose = new Operario("Jose", "Perez", "Jose", "Jose123");
        operarioJose.setActivo(false);

        mozoAlberto = new Mozo("Alberto", "Perez", new Date(1995, 5, 10), 0);

        mesa1 = new Mesa(1, 4);

        try {
            sistema.agregarOperario(operarioJuan);
            sistema.agregarOperario(operarioJose);
            sistema.agregarMozo(mozoAlberto);
            sistema.agregarMesa(mesa1);
        } catch (NombreDeUsuarioNoDisponibleException | MozoYaExistenteException | MesaYaExistenteException e) {

        }
    }

    public static void tearDown() {
        Sistema sistema = Sistema.getInstance();
        sistema.getOperarios().clear();
        sistema.getMozos().clear();
        sistema.getMesas().clear();
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
}
