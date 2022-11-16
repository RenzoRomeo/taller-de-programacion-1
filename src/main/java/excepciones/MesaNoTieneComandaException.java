package excepciones;

public class MesaNoTieneComandaException extends Exception {
    public MesaNoTieneComandaException() {
        super("La mesa no tiene comanda");
    }
}
