package controladores;

import excepciones.OperarioExistenteException;
import modelos.Operario;
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
            String nombreUsuario = vista.getUsuario();
            String contrasenia = vista.getContrasenia();

            if (isDatosValidos(nombre, apellido, nombreUsuario, contrasenia)) {
                try {
                    Operario operario = new Operario(nombre, apellido, nombreUsuario, contrasenia);
                    Sistema.getInstancia().agregarOperario(operario);
                    JOptionPane.showMessageDialog(vista, "Operario creado con éxito", "Operario creado", JOptionPane.INFORMATION_MESSAGE);
                } catch (OperarioExistenteException ex) {
                    JOptionPane.showMessageDialog(vista, "El operario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            Operario operario = new Operario(nombre, apellido, nombreUsuario, contrasenia);
        } else if (cmd.equalsIgnoreCase("mostrarContrasenia")) {
            vista.intercambiarContrasenia();
        } else if (cmd.equalsIgnoreCase("volver")) {
            Principal.getInstancia().setControladorActual(new AdministradorController());
        }
    }

    private boolean isDatosValidos(String nombre, String apellido, String nombreUsuario, String contrasenia) {
        boolean datosValidos = false;
        if (nombre.isBlank() || apellido.isBlank() || nombreUsuario.isBlank() || contrasenia.isBlank()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (nombreUsuario.length() > 10) {
            JOptionPane.showMessageDialog(vista, "El nombre de usuario puede tener hasta 10 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contrasenia.length() > 12 || contrasenia.length() < 6) {
            JOptionPane.showMessageDialog(vista, "La contraseña debe tener entre 6 y 8 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contrasenia.matches(".*[0-9].*")) {
            JOptionPane.showMessageDialog(vista, "La contraseña debe contener al menos un número", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contrasenia.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(vista, "La contraseña debe contener al menos una letra mayúscula", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            datosValidos = true;
        }

        return datosValidos;
    }
}
