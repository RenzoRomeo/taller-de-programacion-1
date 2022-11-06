package controladores;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import modelos.Operario;
import modelos.Sistema;
import vistas.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class LoginController extends Controller<Login> {

    public LoginController() {
        super(new Login());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("login")) {
            String username = vista.getUsername();
            String contrasenia = vista.getContrasenia();

            Iterator<Operario> operarios = Sistema.getInstancia().getOperarios();
            boolean encontrado = false;
            while (operarios.hasNext() && !encontrado) {
                Operario operario = operarios.next();
                if (operario.getNombreUsuario().equals(username)) {
                    encontrado = true;
                    try {
                        operario.iniciarSesion(contrasenia);
                        Controller controller = null;
                        if (operario.getNombreUsuario().equals("admin")) {
                            controller = new AdministradorController();
                        } else {
                            controller = new OperarioController();
                        }
                        Principal.getInstancia().setControladorActual(controller);
                        vista.dispose();
                    } catch (ContraseniaIncorrectaException | UsuarioInactivoException ex) {
                        JOptionPane.showMessageDialog(vista, ex.getMessage());
                    }
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(vista, "El usuario no existe");
            }
        }
    }
}
