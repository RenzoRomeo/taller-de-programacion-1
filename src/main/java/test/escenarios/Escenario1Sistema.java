package test.escenarios;

import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Operario;
import modelo.Sistema;

public class Escenario1Sistema {
    private static Operario juan;
    private static Operario jose;

    public static void setUp() {
        Sistema sistema = Sistema.getInstance();
        juan = new Operario("Juan", "Perez", "Juan", "Juan123");
        jose = new Operario("Jose", "Perez", "Jose", "Jose123");
        jose.setActivo(false);
        try {
            sistema.agregarOperario(juan);
            sistema.agregarOperario(jose);
        } catch (NombreDeUsuarioNoDisponibleException e) {

        }
    }

    public static void tearDown() {
        Sistema sistema = Sistema.getInstance();
        sistema.getOperarios().clear();
    }

    public static Operario getJuan() {
        return juan;
    }

    public static Operario getJose() {
        return jose;
    }
}
