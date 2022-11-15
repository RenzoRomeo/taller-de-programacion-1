package controladores;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioNoExisteException;
import modelo.Sistema;

public class LoginController {
    private static LoginController instance = null;

    private LoginController() {

    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    public void iniciarSesion(String nombre, String contrasen) throws UsuarioNoExisteException, UsuarioInactivoException, ContraseniaIncorrectaException {
        Sistema.getInstance().iniciarSesionOperario(nombre, contrasen);
    }

    public void inicioSesionExitoso() {

    }
}
