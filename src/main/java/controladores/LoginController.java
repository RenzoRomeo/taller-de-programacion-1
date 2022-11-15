package controladores;

import excepciones.ContraseniaIncorrectaException;
import excepciones.OperarioInexistenteException;
import excepciones.UsuarioInactivoException;
import modelos.Operario;
import modelos.Sistema;
import vistas.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginController extends Controller<Login> {

    public LoginController() {
        super(new Login());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("iniciarSesion")) {
            String nombreUsuario = vista.getUsuario();
            String contrasenia = vista.getContrasenia();

            try {
                Operario usuario = Sistema.getInstancia().buscarOperario(nombreUsuario);
                usuario.iniciarSesion(contrasenia);
            } catch (OperarioInexistenteException ex) {
                JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (UsuarioInactivoException ex) {
                JOptionPane.showMessageDialog(vista, ex.getMessage(), "El usuario se encuentra inactivo.", JOptionPane.ERROR_MESSAGE);
            } catch (ContraseniaIncorrectaException ex) {
                JOptionPane.showMessageDialog(vista, ex.getMessage(), "Usuario o contraseña incorrectos", JOptionPane.ERROR_MESSAGE);
            }

        } else if (cmd.equalsIgnoreCase("mostrarContrasenia")) {
            vista.intercambiarContrasenia();
        }
    }
}
