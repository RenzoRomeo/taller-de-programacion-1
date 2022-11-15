package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JButton;

public class VistaAdmin extends JFrame implements IVista {

    private JPanel contentPane;
    private JPanel panelAdmin;
    private JPanel panelModificarOperarios;
    private JButton botonOperarios;
    private JPanel panelModificarMozos;
    private JButton botonMozos;
    private JPanel panelModificarMesas;
    private JButton botonMesas;
    private JPanel panelModificarProductos;
    private JButton botonProductos;
    private JPanel panelAsignarMozos;
    private JButton botonAsignarMozos;
    private JPanel panelCrearPedidos;
    private JButton botonCrearPedido;
    private JPanel panelCerrarMesa;
    private JButton botonCerrarMesa;
    private JPanel panelDatosEstadisticos;
    private JButton botonEstadisticas;


    /**
     * Create the frame.
     */
    public VistaAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        panelAdmin = new JPanel();
        contentPane.add(panelAdmin, BorderLayout.CENTER);
        panelAdmin.setLayout(new GridLayout(4, 0, 0, 0));

        panelModificarOperarios = new JPanel();
        panelAdmin.add(panelModificarOperarios);

        botonOperarios = new JButton("Modificar Operarios");
        panelModificarOperarios.add(botonOperarios);

        panelModificarMozos = new JPanel();
        panelAdmin.add(panelModificarMozos);

        botonMozos = new JButton("Modificar Mozos");
        panelModificarMozos.add(botonMozos);

        panelModificarMesas = new JPanel();
        panelAdmin.add(panelModificarMesas);

        botonMesas = new JButton("Modificar Mesas");
        panelModificarMesas.add(botonMesas);

        panelModificarProductos = new JPanel();
        panelAdmin.add(panelModificarProductos);

        botonProductos = new JButton("Modificar Productos");
        panelModificarProductos.add(botonProductos);

        panelAsignarMozos = new JPanel();
        panelAdmin.add(panelAsignarMozos);

        botonAsignarMozos = new JButton("Asignar Mesa - Mozo");
        panelAsignarMozos.add(botonAsignarMozos);

        panelCrearPedidos = new JPanel();
        panelAdmin.add(panelCrearPedidos);

        botonCrearPedido = new JButton("Crear pedido");
        panelCrearPedidos.add(botonCrearPedido);

        panelCerrarMesa = new JPanel();
        panelAdmin.add(panelCerrarMesa);

        botonCerrarMesa = new JButton("Cerrar mesa");
        panelCerrarMesa.add(botonCerrarMesa);

        panelDatosEstadisticos = new JPanel();
        panelAdmin.add(panelDatosEstadisticos);

        botonEstadisticas = new JButton("Obtener estadisticas");
        panelDatosEstadisticos.add(botonEstadisticas);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        botonOperarios.addActionListener(actionListener);
        botonMozos.addActionListener(actionListener);
        botonMesas.addActionListener(actionListener);
        botonProductos.addActionListener(actionListener);
        botonAsignarMozos.addActionListener(actionListener);
        botonCrearPedido.addActionListener(actionListener);
        botonCerrarMesa.addActionListener(actionListener);
        botonEstadisticas.addActionListener(actionListener);
    }

    @Override
    public void setWindowListener(WindowListener windowListener) {
        addWindowListener(windowListener);
    }
}