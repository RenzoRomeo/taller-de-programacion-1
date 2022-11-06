package vistas;

import javax.swing.*;
import java.awt.event.ActionListener;

public class IniciarSistema extends JFrame implements IVista {
    private JPanel contentPane;
    private JPanel titulo;
    private JTextField tituloText;
    private JPanel principal;
    private JTextField nombreLocalField;
    private JLabel nombreLocalLabel;
    private JPanel nombreLocalPanel;
    private JButton iniciarSistemaButton;
    private JPanel iniciarSistemaButtonPanel;

    @Override
    public void setActionListener(ActionListener actionListener) {
        iniciarSistemaButton.addActionListener(actionListener);
    }

    public String getNombreLocal() {
        return nombreLocalField.getText();
    }
}
