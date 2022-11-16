package excepciones;

public class MesaNoDisponibleException extends Exception {
    public MesaNoDisponibleException() {
        super("La mesa no esta disponible");
    }
}
