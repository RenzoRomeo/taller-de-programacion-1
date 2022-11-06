package excepciones;

public class OperarioExistenteException extends Exception {
    public OperarioExistenteException(String nombreUsuario) {
        super("El nombre de usuario " + nombreUsuario + " ya existe");
    }
}
