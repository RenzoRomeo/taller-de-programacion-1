package excepciones;

public class ContraseniaIncorrectaException extends Throwable {
    public ContraseniaIncorrectaException() {
        super("Contraseña incorrecta");
    }
}
