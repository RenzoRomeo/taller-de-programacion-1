package vistas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements IVista {
    private JPanel contentPane;
    private JPanel principal;
    private JPanel titulo;
    private JTextField tituloText;
    private JLabel nombreUsuarioLabel;
    private JTextField nombreUsuarioField;
    private JPanel nombreUsuarioPanel;
    private JLabel contraseniaLabel;
    private JTextField contraseniaField;
    private JPanel contraseniaPanel;
    private JButton iniciarSesionButton;
    private JPanel iniciarSesionPanel;
    private JButton iniciarSistemaButton;

    public String getUsername() {
        return nombreUsuarioField.getText();
    }

    public String getContrasenia() {
        return contraseniaField.getText();
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        iniciarSesionButton.addActionListener(actionListener);
        iniciarSistemaButton.addActionListener(actionListener);
    }
}
