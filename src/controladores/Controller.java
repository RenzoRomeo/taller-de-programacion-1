package controladores;

import vistas.IVista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class Controller<E extends JFrame & IVista> implements ActionListener, WindowListener {
    protected E vista;

    public Controller(E vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setWindowListener(this);
    }

    public void cerrarVentana() {
        vista.dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO: persistir datos.
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
