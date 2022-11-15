package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VistaOperario extends JFrame implements IVista {

    private JPanel contentPane;
    private JPanel panelOperario;
    private JPanel panelEstadoMozo;
    private JScrollPane scrollPaneMozosEstado;
    private JList listMozosEstado;
    private JPanel panelEstados;
    private JButton botonActivo;
    private JButton botonAusente;
    private JButton botonDeFranco;
    private JPanel panelAsignacion;
    private JScrollPane scrollPaneMesas;
    private JList listMesas;
    private JPanel panelBotones;
    private JPanel panelBotonAsignar;
    private JButton botonAsignar;
    private JPanel panelBotonVovler;
    private JButton botonVolver;


    /**
     * Create the frame.
     */
    public VistaOperario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        panelOperario = new JPanel();
        contentPane.add(panelOperario, BorderLayout.CENTER);
        panelOperario.setLayout(new GridLayout(0, 2, 0, 0));

        panelEstadoMozo = new JPanel();
        panelOperario.add(panelEstadoMozo);
        panelEstadoMozo.setLayout(new GridLayout(2, 2, 0, 0));

        scrollPaneMozosEstado = new JScrollPane();
        panelEstadoMozo.add(scrollPaneMozosEstado);

        listMozosEstado = new JList();
        scrollPaneMozosEstado.setViewportView(listMozosEstado);

        panelEstados = new JPanel();
        panelEstadoMozo.add(panelEstados);
        panelEstados.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        botonActivo = new JButton("Activo");
        panelEstados.add(botonActivo);

        botonAusente = new JButton("Ausente");
        panelEstados.add(botonAusente);

        botonDeFranco = new JButton("De franco");
        panelEstados.add(botonDeFranco);

        panelAsignacion = new JPanel();
        panelOperario.add(panelAsignacion);
        panelAsignacion.setLayout(new GridLayout(2, 1, 0, 0));

        scrollPaneMesas = new JScrollPane();
        panelAsignacion.add(scrollPaneMesas);

        listMesas = new JList();
        scrollPaneMesas.setViewportView(listMesas);

        panelBotones = new JPanel();
        panelAsignacion.add(panelBotones);
        panelBotones.setLayout(new GridLayout(2, 0, 0, 0));

        panelBotonAsignar = new JPanel();
        panelBotones.add(panelBotonAsignar);

        botonAsignar = new JButton("Asignar");
        panelBotonAsignar.add(botonAsignar);

        panelBotonVovler = new JPanel();
        panelBotones.add(panelBotonVovler);

        botonVolver = new JButton("Volver");
        panelBotonVovler.add(botonVolver);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        botonActivo.addActionListener(actionListener);
        botonAusente.addActionListener(actionListener);
        botonDeFranco.addActionListener(actionListener);
        botonAsignar.addActionListener(actionListener);
        botonVolver.addActionListener(actionListener);
    }

    @Override
    public void setWindowListener(WindowListener windowListener) {
        addWindowListener(windowListener);
    }
}

