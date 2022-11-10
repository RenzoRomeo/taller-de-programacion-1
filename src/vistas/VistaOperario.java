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

public class VistaOperario extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaOperario frame = new VistaOperario();
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
    public VistaOperario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelOperario = new JPanel();
        contentPane.add(panelOperario, BorderLayout.CENTER);
        panelOperario.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelEstadoMozo = new JPanel();
        panelOperario.add(panelEstadoMozo);
        panelEstadoMozo.setLayout(new GridLayout(0, 2, 0, 0));

        JScrollPane scrollPaneMozosEstado = new JScrollPane();
        panelEstadoMozo.add(scrollPaneMozosEstado);

        JList listMozosEstado = new JList();
        scrollPaneMozosEstado.setViewportView(listMozosEstado);

        JPanel panelEstados = new JPanel();
        panelEstadoMozo.add(panelEstados);
        panelEstados.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel panelBotonActivo = new JPanel();
        panelEstados.add(panelBotonActivo);

        JButton BotonActivo = new JButton("Activo");
        panelBotonActivo.add(BotonActivo);

        JPanel panelBotonAusente = new JPanel();
        panelEstados.add(panelBotonAusente);

        JButton BotonAusente = new JButton("Ausente");
        panelBotonAusente.add(BotonAusente);

        JPanel panelBotonDeFranco = new JPanel();
        panelEstados.add(panelBotonDeFranco);

        JButton BotonDeFranco = new JButton("De franco");
        panelBotonDeFranco.add(BotonDeFranco);

        JPanel panelAsignacion = new JPanel();
        panelOperario.add(panelAsignacion);
        panelAsignacion.setLayout(new GridLayout(0, 3, 0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panelAsignacion.add(scrollPane);

        JList listMozosAAsignar = new JList();
        scrollPane.setViewportView(listMozosAAsignar);

        JPanel panelBoton = new JPanel();
        panelAsignacion.add(panelBoton);
        panelBoton.setLayout(new GridLayout(3, 1, 0, 0));

        JPanel panel = new JPanel();
        panelBoton.add(panel);

        JPanel panelBotonAsignar = new JPanel();
        panelBoton.add(panelBotonAsignar);

        JButton botonAsignar = new JButton("Asignar");
        panelBotonAsignar.add(botonAsignar);

        JScrollPane scrollPane_1 = new JScrollPane();
        panelAsignacion.add(scrollPane_1);

        JList listMesasAAsignar = new JList();
        scrollPane_1.setViewportView(listMesasAAsignar);
    }

}
