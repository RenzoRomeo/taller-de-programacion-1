package vistasViejas;

import vistas.IVista;

import java.awt.event.ActionListener;

public class Administrador implements IVista {
    private JPanel contentPane;
    private JTextField tituloText;
    private JPanel tituloPanel;
    private JButton gestionarOperariosButton;
    private JPanel gestionarOperariosPanel;
    private JButton gestionarMozosButton;
    private JPanel gestionarMozosPanel;
    private JButton gestionarMesasButton;
    private JPanel gestionarMesasPanel;
    private JButton gestionarProductosButton;
    private JPanel gestionarProductosPanel;

    @Override
    public void setActionListener(ActionListener actionListener) {
        gestionarOperariosButton.addActionListener(actionListener);
        gestionarMozosButton.addActionListener(actionListener);
        gestionarMesasButton.addActionListener(actionListener);
        gestionarProductosButton.addActionListener(actionListener);
    }
}
