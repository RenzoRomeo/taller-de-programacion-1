package excepciones;

public class ProductoNoDisponibleException extends Exception {
    public ProductoNoDisponibleException() {
        super("El producto no está disponible");
    }
}
