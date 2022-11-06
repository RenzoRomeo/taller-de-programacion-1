package controladores;

import vistas.IVista;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public abstract class Controller<E extends IVista> implements ActionListener, WindowListener {
    protected E vista;

    public Controller(E vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
        this.vista.setWindowListener(this);
    }
}
