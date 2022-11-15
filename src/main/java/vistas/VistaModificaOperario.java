package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VistaModificaOperario extends JFrame implements IVista {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldContrasenia;
    private JPanel panelModificaOperario;
    private JPanel panelEliminarOperario;
    private JScrollPane scrollPaneOperarios;
    private JList listOperarios;
    private JPanel panelBotones;
    private JPanel panelBotonEliminar;
    private JButton botonEliminar;
    private JPanel panelBotonVolver;
    private JButton botonVolver;
    private JPanel panelAgregarOperario;
    private JPanel panelNombre;
    private JPanel panelLabelNombre;
    private JLabel labelNombre;
    private JPanel panelTextNombre;
    private JPanel panelLabelApellido;
    private JLabel labelApellido;
    private JPanel panelTextApellido;
    private JPanel panelLabelNombreUsuario;
    private JLabel labelNombreUsuario;
    private JPanel panelTextNombreUsuario;
    private JPanel panelContrasenia;
    private JPanel panelLabelContrasenia;
    private JLabel labelContrasenia;
    private JPanel panelTextContrasenia;
    private JPanel panelBotonAgregar;
    private JButton botonAgregar;


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

        panelModificaOperario = new JPanel();
        contentPane.add(panelModificaOperario, BorderLayout.CENTER);
        panelModificaOperario.setLayout(new GridLayout(0, 2, 0, 0));

        panelEliminarOperario = new JPanel();
        panelModificaOperario.add(panelEliminarOperario);
        panelEliminarOperario.setLayout(new GridLayout(2, 0, 0, 0));

        scrollPaneOperarios = new JScrollPane();
        panelEliminarOperario.add(scrollPaneOperarios);

        listOperarios = new JList();
        scrollPaneOperarios.setViewportView(listOperarios);

        panelBotones = new JPanel();
        panelEliminarOperario.add(panelBotones);
        panelBotones.setLayout(new GridLayout(2, 1, 0, 0));

        panelBotonEliminar = new JPanel();
        panelBotones.add(panelBotonEliminar);

        botonEliminar = new JButton("Eliminar");
        panelBotonEliminar.add(botonEliminar);

        panelBotonVolver = new JPanel();
        panelBotones.add(panelBotonVolver);

        botonVolver = new JButton("Volver");
        panelBotonVolver.add(botonVolver);

        panelAgregarOperario = new JPanel();
        panelModificaOperario.add(panelAgregarOperario);
        panelAgregarOperario.setLayout(new GridLayout(5, 0, 0, 0));

        panelNombre = new JPanel();
        panelAgregarOperario.add(panelNombre);
        panelNombre.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelNombre = new JPanel();
        panelNombre.add(panelLabelNombre);

        labelNombre = new JLabel("Nombre:");
        panelLabelNombre.add(labelNombre);

        panelTextNombre = new JPanel();
        panelNombre.add(panelTextNombre);

        textFieldNombre = new JTextField();
        panelTextNombre.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JPanel panelApellido = new JPanel();
        panelAgregarOperario.add(panelApellido);
        panelApellido.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelApellido = new JPanel();
        panelApellido.add(panelLabelApellido);

        labelApellido = new JLabel("Apellido:");
        panelLabelApellido.add(labelApellido);

        panelTextApellido = new JPanel();
        panelApellido.add(panelTextApellido);

        textFieldApellido = new JTextField();
        panelTextApellido.add(textFieldApellido);
        textFieldApellido.setColumns(10);

        JPanel panelNombreUsuario = new JPanel();
        panelAgregarOperario.add(panelNombreUsuario);
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
        panelAgregarOperario.add(panelContrasenia);
        panelContrasenia.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelContrasenia = new JPanel();
        panelContrasenia.add(panelLabelContrasenia);

        labelContrasenia = new JLabel("Contrasenia:");
        panelLabelContrasenia.add(labelContrasenia);

        panelTextContrasenia = new JPanel();
        panelContrasenia.add(panelTextContrasenia);

        textFieldContrasenia = new JTextField();
        panelTextContrasenia.add(textFieldContrasenia);
        textFieldContrasenia.setColumns(10);

        panelBotonAgregar = new JPanel();
        panelAgregarOperario.add(panelBotonAgregar);

        botonAgregar = new JButton("Agregar");
        panelBotonAgregar.add(botonAgregar);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        botonAgregar.addActionListener(actionListener);
        botonEliminar.addActionListener(actionListener);
        botonVolver.addActionListener(actionListener);
    }

    @Override
    public void setWindowListener(WindowListener windowListener) {
        addWindowListener(windowListener);

    }
}