package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VistaLogin extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldContrasenia;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaLogin frame = new VistaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VistaLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelLogin = new JPanel();
        contentPane.add(panelLogin, BorderLayout.CENTER);
        panelLogin.setLayout(new GridLayout(4, 0, 0, 0));

        JPanel panelNombreUsuario = new JPanel();
        panelLogin.add(panelNombreUsuario);
        panelNombreUsuario.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelNombreUsuario = new JPanel();
        panelNombreUsuario.add(panelLabelNombreUsuario);

        JLabel labelNombreUsuario = new JLabel("Nombre de usuario:");
        panelLabelNombreUsuario.add(labelNombreUsuario);

        JPanel panelTextNombreUsuario = new JPanel();
        panelNombreUsuario.add(panelTextNombreUsuario);

        textFieldNombreUsuario = new JTextField();
        panelTextNombreUsuario.add(textFieldNombreUsuario);
        textFieldNombreUsuario.setColumns(10);

        JPanel panelContrasenia = new JPanel();
        panelLogin.add(panelContrasenia);
        panelContrasenia.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelContrasenia = new JPanel();
        panelContrasenia.add(panelLabelContrasenia);

        JLabel LabelContrasenia = new JLabel("Contrasenia:");
        panelLabelContrasenia.add(LabelContrasenia);

        JPanel panelTextContrasenia = new JPanel();
        panelContrasenia.add(panelTextContrasenia);

        textFieldContrasenia = new JTextField();
        panelTextContrasenia.add(textFieldContrasenia);
        textFieldContrasenia.setColumns(10);

        JPanel panelComboBoxTipoUsuario = new JPanel();
        panelLogin.add(panelComboBoxTipoUsuario);

        JComboBox comboBoxUsuario = new JComboBox();
        panelComboBoxTipoUsuario.add(comboBoxUsuario);
        //agrego admin y operario a la lista desplegable
        comboBoxUsuario.addItem("admin");
        comboBoxUsuario.addItem("operario");

        JPanel panelBoton = new JPanel();
        panelLogin.add(panelBoton);

        JButton botonLogin = new JButton("Login");
        panelBoton.add(botonLogin);
    }

}