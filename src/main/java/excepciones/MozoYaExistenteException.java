package excepciones;

public class MozoYaExistenteException extends Exception {
    public MozoYaExistenteException() {
        super("El mozo ya existe");
    }
}

