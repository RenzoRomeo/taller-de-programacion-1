package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;


public class VistaAdmin extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaAdmin frame = new VistaAdmin();
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
    public VistaAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelAdmin = new JPanel();
        contentPane.add(panelAdmin, BorderLayout.CENTER);
        panelAdmin.setLayout(new GridLayout(5, 0, 0, 0));

        JPanel panelModificarOperarios = new JPanel();
        panelAdmin.add(panelModificarOperarios);

        JButton botonOperarios = new JButton("Modificar Operarios");
        panelModificarOperarios.add(botonOperarios);

        JPanel panelModificarMozos = new JPanel();
        panelAdmin.add(panelModificarMozos);

        JButton botonMozos = new JButton("Modificar Mozos");
        panelModificarMozos.add(botonMozos);

        JPanel panelModificarMesas = new JPanel();
        panelAdmin.add(panelModificarMesas);

        JButton botonMesas = new JButton("Modificar Mesas");
        panelModificarMesas.add(botonMesas);

        JPanel panelModificarProductos = new JPanel();
        panelAdmin.add(panelModificarProductos);

        JButton botonProductos = new JButton("Modificar Productos");
        panelModificarProductos.add(botonProductos);

        JPanel panelAsignarMozos = new JPanel();
        panelAdmin.add(panelAsignarMozos);

        JButton botonAsignarMozos = new JButton("Asignar Mesa - Mozo");
        panelAsignarMozos.add(botonAsignarMozos);
    }

}
