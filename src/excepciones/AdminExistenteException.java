package excepciones;

public class AdminExistenteException extends Exception{
    public AdminExistenteException() {
        super("Ya existe un administrador");
    }
}
