package excepciones;

public class UsuarioInactivoException extends Exception {
    public UsuarioInactivoException() {
        super("Usuario está inactivo");
    }
}
