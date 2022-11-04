package controladores;

import vistas.IVista;

import java.awt.event.ActionListener;

public abstract class Controller<E extends IVista> implements ActionListener {
    protected E vista;

    public Controller(E vista) {
        this.vista = vista;
        this.vista.setActionListener(this);
    }
}
