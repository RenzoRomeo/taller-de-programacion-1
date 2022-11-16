package test;

import excepciones.NombreDeUsuarioNoDisponibleException;
import modelo.Operario;
import modelo.Sistema;

public class EscenariosSistema {
    public static void escenario1() {
        Sistema sistema = Sistema.getInstance();
        Operario juan = new Operario("Juan", "Perez", "Juan", "Juan123");
        Operario jose = new Operario("Jose", "Perez", "Jose", "Jose123");
        jose.setActivo(false);
        try {
            sistema.agregarOperario(juan);
            sistema.agregarOperario(jose);
        } catch (NombreDeUsuarioNoDisponibleException e) {

        }
    }
}
