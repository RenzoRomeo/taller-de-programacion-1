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
    private JPanel panelLogin;
    private JPanel panelNombreUsuario;
    private JPanel panelLabelNombreUsuario;
    private JLabel labelNombreUsuario;
    private JPanel panelTextNombreUsuario;
    private JPanel panelContrasenia;
    private JPanel panelLabelContrasenia;
    private JLabel LabelContrasenia;
    private JPanel panelTextContrasenia;
    private JPanel panelComboBoxTipoUsuario;
    private JComboBox comboBoxUsuario;
    private JPanel panelBoton;
    private JButton botonLogin;

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

        panelLogin = new JPanel();
        contentPane.add(panelLogin, BorderLayout.CENTER);
        panelLogin.setLayout(new GridLayout(4, 0, 0, 0));

        panelNombreUsuario = new JPanel();
        panelLogin.add(panelNombreUsuario);
        panelNombreUsuario.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelNombreUsuario = new JPanel();
        panelNombreUsuario.add(panelLabelNombreUsuario);

        labelNombreUsuario = new JLabel("Nombre de usuario:");
        panelLabelNombreUsuario.add(labelNombreUsuario);

        panelTextNombreUsuario = new JPanel();
        panelNombreUsuario.add(panelTextNombreUsuario);

        textFieldNombreUsuario = new JTextField();
        panelTextNombreUsuario.add(textFieldNombreUsuario);
        textFieldNombreUsuario.setColumns(10);

        panelContrasenia = new JPanel();
        panelLogin.add(panelContrasenia);
        panelContrasenia.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelContrasenia = new JPanel();
        panelContrasenia.add(panelLabelContrasenia);

        LabelContrasenia = new JLabel("Contrasenia:");
        panelLabelContrasenia.add(LabelContrasenia);

        panelTextContrasenia = new JPanel();
        panelContrasenia.add(panelTextContrasenia);

        textFieldContrasenia = new JTextField();
        panelTextContrasenia.add(textFieldContrasenia);
        textFieldContrasenia.setColumns(10);

        panelComboBoxTipoUsuario = new JPanel();
        panelLogin.add(panelComboBoxTipoUsuario);

        comboBoxUsuario = new JComboBox();
        panelComboBoxTipoUsuario.add(comboBoxUsuario);

        panelBoton = new JPanel();
        panelLogin.add(panelBoton);

        botonLogin = new JButton("Login");
        panelBoton.add(botonLogin);
    }

}