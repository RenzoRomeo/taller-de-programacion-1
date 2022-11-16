package excepciones;

public class MozoNoExisteException extends Exception {
    public MozoNoExisteException() {
        super("El mozo no existe");
    }
}
