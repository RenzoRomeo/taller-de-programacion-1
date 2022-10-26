package modelos;

import excepciones.AdministradorExistenteException;

/**
 * Clase que representa a un administrador del sistema.
 * <b>Inv:</b>
 * Existe una unica instancia que se crea al inicio del programa.
 */
public class Administrador extends Operario {
    private boolean establecioContrasenia;
    private static Administrador instancia;
    private static boolean inicializado = false;

    /**
     * Crea un administrador con los valores por defecto.
     * <b>Post:</b>
     * establecioContrasenia == false
     */
    private Administrador() {
        super("ADMIN", "ADMIN", "ADMIN", "ADMIN1234");
        establecioContrasenia = false;

        assert !establecioContrasenia : "No se estableció el atributo 'establecioContrasenia'";
    }

    public static Administrador crearAdministrador() throws AdministradorExistenteException {
        if (inicializado)
            throw new AdministradorExistenteException();

        Administrador administrador = new Administrador();
        inicializado = true;

        return administrador;
    }

    /**
     * <b>Post:</b>
     * Se establece la contraseña del administrador.
     */
    @Override
    public void cambiarContrasenia(String contraseniaNueva) {
        super.cambiarContrasenia(contraseniaNueva);
        establecioContrasenia = true;

        assert establecioContrasenia;
    }

    public static boolean isInicializado() {
        return inicializado;
    }
}
