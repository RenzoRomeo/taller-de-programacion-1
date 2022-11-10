package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaModificaOperario extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldContrasenia;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaModificaOperario frame = new VistaModificaOperario();
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
    public VistaModificaOperario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelModificaOperario = new JPanel();
        contentPane.add(panelModificaOperario, BorderLayout.CENTER);
        panelModificaOperario.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelEliminarOperario = new JPanel();
        panelModificaOperario.add(panelEliminarOperario);
        panelEliminarOperario.setLayout(new GridLayout(2, 0, 0, 0));

        JScrollPane scrollPaneOperarios = new JScrollPane();
        panelEliminarOperario.add(scrollPaneOperarios);

        JList listOperarios = new JList();
        scrollPaneOperarios.setViewportView(listOperarios);

        JPanel panelBotones = new JPanel();
        panelEliminarOperario.add(panelBotones);
        panelBotones.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panelBotonEliminar = new JPanel();
        panelBotones.add(panelBotonEliminar);

        JButton botonEliminar = new JButton("Eliminar");
        panelBotonEliminar.add(botonEliminar);

        JPanel panelBotonVolver = new JPanel();
        panelBotones.add(panelBotonVolver);

        JButton botonVolver = new JButton("Volver");
        panelBotonVolver.add(botonVolver);

        JPanel panelAgregarOperario = new JPanel();
        panelModificaOperario.add(panelAgregarOperario);
        panelAgregarOperario.setLayout(new GridLayout(5, 0, 0, 0));

        JPanel panelNombre = new JPanel();
        panelAgregarOperario.add(panelNombre);
        panelNombre.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelNombre = new JPanel();
        panelNombre.add(panelLabelNombre);

        JLabel labelNombre = new JLabel("Nombre:");
        panelLabelNombre.add(labelNombre);

        JPanel panelTextNombre = new JPanel();
        panelNombre.add(panelTextNombre);

        textFieldNombre = new JTextField();
        panelTextNombre.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JPanel panelApellido = new JPanel();
        panelAgregarOperario.add(panelApellido);
        panelApellido.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelApellido = new JPanel();
        panelApellido.add(panelLabelApellido);

        JLabel labelApellido = new JLabel("Apellido:");
        panelLabelApellido.add(labelApellido);

        JPanel panelTextApellido = new JPanel();
        panelApellido.add(panelTextApellido);

        textFieldApellido = new JTextField();
        panelTextApellido.add(textFieldApellido);
        textFieldApellido.setColumns(10);

        JPanel panelNombreUsuario = new JPanel();
        panelAgregarOperario.add(panelNombreUsuario);
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
        panelAgregarOperario.add(panelContrasenia);
        panelContrasenia.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelContrasenia = new JPanel();
        panelContrasenia.add(panelLabelContrasenia);

        JLabel labelContrasenia = new JLabel("Contrasenia:");
        panelLabelContrasenia.add(labelContrasenia);

        JPanel panelTextContrasenia = new JPanel();
        panelContrasenia.add(panelTextContrasenia);

        textFieldContrasenia = new JTextField();
        panelTextContrasenia.add(textFieldContrasenia);
        textFieldContrasenia.setColumns(10);

        JPanel panelBotonAgregar = new JPanel();
        panelAgregarOperario.add(panelBotonAgregar);

        JButton botonAgregar = new JButton("Agregar");
        panelBotonAgregar.add(botonAgregar);
    }

}