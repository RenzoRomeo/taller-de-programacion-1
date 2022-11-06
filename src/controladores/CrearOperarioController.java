package controladores;

import modelos.Sistema;
import vistas.CrearOperario;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CrearOperarioController extends Controller<CrearOperario> {
    public CrearOperarioController() {
        super(new CrearOperario());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("crearOperario")) {
            String nombre = vista.getNombre();
            String apellido = vista.getApellido();
            String nombreUsuario = vista.getNombreUsuario();
            String contrasenia = vista.getContrasenia();

            if (nombre.isEmpty() || apellido.isEmpty() || nombreUsuario.isEmpty() || contrasenia.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Debe completar todos los campos");
            } else if (nombreUsuario.length() >= 10) {
                JOptionPane.showMessageDialog(vista, "El nombre de usuario no puede tener más de 10 caracteres");
            } else if (contrasenia.length() < 6 || contrasenia.length() > 12) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe tener entre 6 y 12 caracteres");
            } else if (!contrasenia.matches(".*[0-9].*")) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe contener al menos un número");
            } else if (!contrasenia.matches(".*[A-Z].*")) {
                JOptionPane.showMessageDialog(vista, "La contraseña debe contener al menos una letra mayúscula");
            } else {
                try {
                    Sistema.getInstancia().crearOperario(nombre, apellido, nombreUsuario, contrasenia);
                    JOptionPane.showMessageDialog(vista, "Operario creado con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, ex.getMessage());
                }
                JOptionPane.showMessageDialog(vista, "Operario creado con éxito");
            }
        } else if (cmd.equalsIgnoreCase("volver")) {
            Principal.getInstancia().setControladorActual(new AdministradorController());
            vista.dispose();
        }
    }
}
