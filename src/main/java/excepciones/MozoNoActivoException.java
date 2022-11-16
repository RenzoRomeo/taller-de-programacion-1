package excepciones;

public class MozoNoActivoException extends Exception {
    public MozoNoActivoException() {
        super("El mozo no esta activo");
    }
}
