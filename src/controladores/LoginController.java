package controladores;

import excepciones.AdministradorExistenteException;
import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import modelos.Administrador;
import vistas.Login;

import java.awt.event.ActionEvent;

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

            if (username.equalsIgnoreCase("admin")) {
                try {
                    Administrador admin = Administrador.crearAdministrador();
                    admin.iniciarSesion(contrasenia);


                } catch (AdministradorExistenteException ex) {

                } catch (UsuarioInactivoException ex) {

                } catch (ContraseniaIncorrectaException ex) {

                }
            }
        } else if (cmd.equalsIgnoreCase("iniciarSistema")) {

        }
    }
}
