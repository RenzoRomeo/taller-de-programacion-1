package excepciones;

public class MesaYaExistenteException extends Exception {
    public MesaYaExistenteException() {
        super("La mesa ya existe");
    }
}
