package controladores;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modelo.Sistema;
import vistas.IVista;
import vistas.IVista;

public abstract class Controller<E extends IVista> implements ActionListener, WindowListener {
    protected E vista;

    public Controller(E vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {
        SistemaController.getInstance().cerrarSistema();
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
