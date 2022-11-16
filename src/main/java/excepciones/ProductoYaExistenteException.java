package excepciones;

public class ProductoYaExistenteException extends Exception {
    public ProductoYaExistenteException() {
        super("El producto ya existe");
    }
}
