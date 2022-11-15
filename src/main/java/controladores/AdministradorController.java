package controladores;

import vistas.Administrador;

import java.awt.event.ActionEvent;

public class AdministradorController extends Controller<Administrador> {
    public AdministradorController() {
        super(new Administrador());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("gestionarNegocio")) {
            Principal.getInstancia().setControladorActual(new GestionarNegocioController());
        } else if (cmd.equalsIgnoreCase("gestionarOperarios")) {
            Principal.getInstancia().setControladorActual(new GestionarOperariosController());
        } else if (cmd.equalsIgnoreCase("gestionarProductos")) {
            Principal.getInstancia().setControladorActual(new GestionarProductosController());
        } else if (cmd.equalsIgnoreCase("cerrarSesion")) {
            Principal.getInstancia().setControladorActual(new LoginController());
        } else if (cmd.equalsIgnoreCase("gestionarMesas")) {
            Principal.getInstancia().setControladorActual(new GestionarMesasController());
        } else if (cmd.equalsIgnoreCase("gestionarMozos")) {
            Principal.getInstancia().setControladorActual(new GestionarMozosController());
        }
    }
}
