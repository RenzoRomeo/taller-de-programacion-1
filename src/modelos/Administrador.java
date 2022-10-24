package modelos;

/**
 * Clase que representa a un administrador del sistema.
 * <b>Inv:</b>
 * Existe una unica instancia que se crea al inicio del programa.
 */
public class Administrador extends Operario {
    private boolean establecioContrasenia;

    public Administrador() {
        super("ADMIN", "ADMIN", "ADMIN", "ADMIN1234");
        establecioContrasenia = false;
    }
}
