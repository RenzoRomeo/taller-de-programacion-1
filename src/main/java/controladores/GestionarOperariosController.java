package controladores;

import excepciones.OperarioInexistenteException;
import modelos.Operario;
import modelos.Sistema;
import vistas.GestionarOperarios;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GestionarOperariosController extends Controller<GestionarOperarios> {

    public GestionarOperariosController() {
        super(new GestionarOperarios());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("eliminarOperario")) {
            Operario operario = vista.getOperarioSeleccionado();
            if (operario == null) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un operario para eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro que desea eliminar al operario " + operario.getNombre() + " " + operario.getApellido() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    try {
                        Sistema.getInstancia().eliminarOperario(operario);
                    } catch (OperarioInexistenteException ex) {
                        JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (cmd.equalsIgnoreCase("crearOperario")) {
            Principal.getInstancia().setControladorActual(new CrearOperarioController());
        } else if (cmd.equalsIgnoreCase("volver")) {
            Principal.getInstancia().setControladorActual(new AdministradorController());
        }
    }
}
