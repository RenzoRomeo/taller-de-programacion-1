package excepciones;

public class NombreDeUsuarioNoDisponibleException extends Exception {
    public NombreDeUsuarioNoDisponibleException(String nombreDeUsuario) {
        super("El nombre de usuario " + nombreDeUsuario + " no está disponible");
    }
}
