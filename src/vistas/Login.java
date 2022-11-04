package vistas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements IVista{
    private JPanel contentPane;
    private JPanel principal;
    private JPanel titulo;
    private JTextField tituloText;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JPanel usernamePanel;
    private JLabel contraseniaLabel;
    private JTextField contraseniaField;
    private JPanel contraseniaPanel;
    private JButton loginButton;
    private JPanel buttonsPanel;
    private JButton iniciarSistemaButton;

    public String getUsername() {
        return usernameField.getText();
    }

    public String getContrasenia() {
        return contraseniaField.getText();
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
        iniciarSistemaButton.addActionListener(actionListener);
    }
}
