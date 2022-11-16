package test.escenarios;

import excepciones.MozoYaExistenteException;
import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Mozo;
import modelo.Operario;
import modelo.Sistema;

import java.util.Date;

public class Escenario1Sistema {
    private static Operario operarioJuan;
    private static Operario operarioJose;

    private static Mozo mozoAlberto;

    public static void setUp() {
        Sistema sistema = Sistema.getInstance();
        operarioJuan = new Operario("Juan", "Perez", "Juan", "Juan123");
        operarioJose = new Operario("Jose", "Perez", "Jose", "Jose123");
        operarioJose.setActivo(false);

        mozoAlberto = new Mozo("Alberto", "Perez", new Date(1995, 5, 10), 0);

        try {
            sistema.agregarOperario(operarioJuan);
            sistema.agregarOperario(operarioJose);
            sistema.agregarMozo(mozoAlberto);
        } catch (NombreDeUsuarioNoDisponibleException | MozoYaExistenteException e) {

        }
    }

    public static void tearDown() {
        Sistema sistema = Sistema.getInstance();
        sistema.getOperarios().clear();
        sistema.getMozos().clear();
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
}
