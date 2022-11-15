package controladores;

import vistas.IniciarSistema;

import java.awt.event.ActionEvent;

public class IniciarSistemaController extends Controller<IniciarSistema> {

    public IniciarSistemaController() {
        super(new IniciarSistema());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("iniciarSistema")) {

        }
    }

}
