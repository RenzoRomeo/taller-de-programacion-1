package excepciones;

public class CantidadEnPromocionMenorException extends Exception {
    public CantidadEnPromocionMenorException() {
        super("La cantidad en promocion es menor a la cantidad minima");
    }
}
