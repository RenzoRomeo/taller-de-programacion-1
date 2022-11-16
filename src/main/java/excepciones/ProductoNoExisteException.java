package excepciones;

public class ProductoNoExisteException extends Exception {
    public ProductoNoExisteException() {
        super("El producto no existe");
    }
}
