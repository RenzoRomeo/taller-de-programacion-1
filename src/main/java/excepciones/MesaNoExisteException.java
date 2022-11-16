package excepciones;

public class MesaNoExisteException extends Exception {
    public MesaNoExisteException() {
        super("La mesa no existe");
    }
}
