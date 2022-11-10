package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaCambioContrasenia extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldContraseniaAnterior;
    private JTextField textFieldContraseniaNueva;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaCambioContrasenia frame = new VistaCambioContrasenia();
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
    public VistaCambioContrasenia() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelCambioContrasenia = new JPanel();
        contentPane.add(panelCambioContrasenia, BorderLayout.CENTER);
        panelCambioContrasenia.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel panelContraseniaAnterior = new JPanel();
        panelCambioContrasenia.add(panelContraseniaAnterior);
        panelContraseniaAnterior.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabelContraseniaAnterior = new JPanel();
        panelContraseniaAnterior.add(panelLabelContraseniaAnterior);

        JLabel LabelContraseniaAnterior = new JLabel("Contrasenia anterior:");
        panelLabelContraseniaAnterior.add(LabelContraseniaAnterior);

        JPanel panelTextContraseniaAnterior = new JPanel();
        panelContraseniaAnterior.add(panelTextContraseniaAnterior);

        textFieldContraseniaAnterior = new JTextField();
        panelTextContraseniaAnterior.add(textFieldContraseniaAnterior);
        textFieldContraseniaAnterior.setColumns(10);

        JPanel panelContrseniaNueva = new JPanel();
        panelCambioContrasenia.add(panelContrseniaNueva);
        panelContrseniaNueva.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLabeContraseniaNueva = new JPanel();
        panelContrseniaNueva.add(panelLabeContraseniaNueva);

        JLabel LabelContraseniaNueva = new JLabel("Nueva contrasenia:");
        panelLabeContraseniaNueva.add(LabelContraseniaNueva);

        JPanel panelTextContraseniaNueva = new JPanel();
        panelContrseniaNueva.add(panelTextContraseniaNueva);

        textFieldContraseniaNueva = new JTextField();
        panelTextContraseniaNueva.add(textFieldContraseniaNueva);
        textFieldContraseniaNueva.setColumns(10);

        JPanel panelBotonAceptar = new JPanel();
        panelCambioContrasenia.add(panelBotonAceptar);

        JButton BotonAceptar = new JButton("Aceptar");
        panelBotonAceptar.add(BotonAceptar);
    }

}
