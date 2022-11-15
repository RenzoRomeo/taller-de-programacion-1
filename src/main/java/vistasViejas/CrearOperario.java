package vistasViejas;

import vistas.IVista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CrearOperario extends JFrame implements IVista {
    private JPanel contentPane;
    private JTextField tituloText;
    private JPanel titulo;
    private JLabel contraseniaLabel;
    private JTextField contraseniaField;
    private JPanel contraseniaPanel;
    private JButton crearOperarioButton;
    private JButton volverButton;
    private JPanel botonesPanel;
    private JLabel nombreUsuarioLabel;
    private JTextField nombreUsuarioField;
    private JPanel nombreUsuarioPanel;
    private JLabel nombreLabel;
    private JTextField nombreField;
    private JPanel nombrePanel;
    private JLabel apellidoLabel;
    private JTextField apellidoField;
    private JPanel apellidoPanel;

    @Override
    public void setActionListener(ActionListener actionListener) {
        crearOperarioButton.addActionListener(actionListener);
        volverButton.addActionListener(actionListener);
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public String getApellido() {
        return apellidoField.getText();
    }

    public String getNombreUsuario() {
        return nombreUsuarioField.getText();
    }

    public String getContrasenia() {
        return contraseniaField.getText();
    }
}
