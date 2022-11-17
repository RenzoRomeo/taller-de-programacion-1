package testCajaBlanca;

import excepciones.OperarioInexistenteException;
import modelos.Administrador;
import modelos.Operario;
import modelos.Sistema;

import java.util.ArrayList;

public class BuscarOperarioCobertura {
    public static Operario buscarOperario(String nombreUsuario) throws OperarioInexistenteException {
        ArrayList<Operario> operarios = new ArrayList<>();
        Administrador admin = Sistema.getInstancia().getAdministrador();
        operarios = (ArrayList<Operario>) Sistema.getInstancia().getOperarios();
        for (Operario operario : operarios) {
            if (operario.getNombreUsuario().equals(nombreUsuario)) {
                return operario;
            }
        }
        if (admin.getNombreUsuario().equals(nombreUsuario)) {
            return admin;
        } else {
            throw new OperarioInexistenteException(nombreUsuario);
        }
    }
}
