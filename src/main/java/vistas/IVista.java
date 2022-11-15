package vistas;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public interface IVista {
    public void setActionListener(ActionListener actionListener);

    public void setWindowListener(WindowListener windowListener);
}
