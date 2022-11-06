package controladores;

// TODO: Cambiar nombre de esta clase, no sabía como ponerle.
public class Principal {
    private static Principal instancia = null;
    private Controller controladorActual;

    private Principal() {

    }

    public static Principal getInstancia() {
        if (instancia == null) {
            instancia = new Principal();
        }

        return instancia;
    }

    public void setControladorActual(Controller controlador) {
        controladorActual.cerrarVentana();
        controladorActual = controlador;
    }

    public void persistirSistema() {

    }

    public void despersistirSistema() {

    }
}
