package excepciones;

public class UsuarioNoExisteException extends Throwable {
    public UsuarioNoExisteException() {
        super("Usuario no existe");
    }
}
