package excepciones;

public class EstadoMozoInvalidoException extends Exception {
    public EstadoMozoInvalidoException() {
        super("El estado del mozo no es válido");
    }
}
