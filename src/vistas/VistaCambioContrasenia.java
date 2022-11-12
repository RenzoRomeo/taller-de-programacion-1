package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaCambioContrasenia extends JFrame implements IVista {

    private JPanel contentPane;
    private JTextField textFieldContraseniaAnterior;
    private JTextField textFieldContraseniaNueva;
    private JPanel panelCambioContrasenia;
    private JPanel panelContraseniaAnterior;
    private JPanel panelLabelContraseniaAnterior;
    private JLabel LabelContraseniaAnterior;
    private JPanel panelTextContraseniaAnterior;
    private JPanel panelContrseniaNueva;
    private JPanel panelLabeContraseniaNueva;
    private JLabel LabelContraseniaNueva;
    private JPanel panelTextContraseniaNueva;
    private JPanel panelBotonAceptar;
    private JButton BotonAceptar;

    /**
     * Create the frame.
     */
    public VistaCambioContrasenia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        panelCambioContrasenia = new JPanel();
        contentPane.add(panelCambioContrasenia, BorderLayout.CENTER);
        panelCambioContrasenia.setLayout(new GridLayout(3, 0, 0, 0));

        panelContraseniaAnterior = new JPanel();
        panelCambioContrasenia.add(panelContraseniaAnterior);
        panelContraseniaAnterior.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabelContraseniaAnterior = new JPanel();
        panelContraseniaAnterior.add(panelLabelContraseniaAnterior);

        LabelContraseniaAnterior = new JLabel("Contrasenia anterior:");
        panelLabelContraseniaAnterior.add(LabelContraseniaAnterior);

        panelTextContraseniaAnterior = new JPanel();
        panelContraseniaAnterior.add(panelTextContraseniaAnterior);

        textFieldContraseniaAnterior = new JTextField();
        panelTextContraseniaAnterior.add(textFieldContraseniaAnterior);
        textFieldContraseniaAnterior.setColumns(10);

        panelContrseniaNueva = new JPanel();
        panelCambioContrasenia.add(panelContrseniaNueva);
        panelContrseniaNueva.setLayout(new GridLayout(0, 2, 0, 0));

        panelLabeContraseniaNueva = new JPanel();
        panelContrseniaNueva.add(panelLabeContraseniaNueva);

        LabelContraseniaNueva = new JLabel("Nueva contrasenia:");
        panelLabeContraseniaNueva.add(LabelContraseniaNueva);

        panelTextContraseniaNueva = new JPanel();
        panelContrseniaNueva.add(panelTextContraseniaNueva);

        textFieldContraseniaNueva = new JTextField();
        panelTextContraseniaNueva.add(textFieldContraseniaNueva);
        textFieldContraseniaNueva.setColumns(10);

        panelBotonAceptar = new JPanel();
        panelCambioContrasenia.add(panelBotonAceptar);

        BotonAceptar = new JButton("Aceptar");
        panelBotonAceptar.add(BotonAceptar);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
        BotonAceptar.addActionListener(actionListener);
    }

    @Override
    public void setWindowListener(WindowListener windowListener) {
        addWindowListener(windowListener);
    }
}
