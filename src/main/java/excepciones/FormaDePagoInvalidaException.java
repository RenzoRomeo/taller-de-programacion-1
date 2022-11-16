package excepciones;

public class FormaDePagoInvalidaException extends Exception {
    public FormaDePagoInvalidaException() {
        super("La forma de pago es invalida");
    }
}
