package testCajaBlanca;

import excepciones.MesaInexistenteException;
import excepciones.MesaNoOcupadaException;
import modelos.Comanda;
import modelos.Mesa;
import modelos.Mozo;
import modelos.Sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CerrarComandaCobertura {
    public static void cerrarComanda(Mesa mesa)throws MesaInexistenteException, MesaNoOcupadaException{
        assert mesa != null : "La mesa no puede ser nula";
        ArrayList<Mesa> mesas = (ArrayList<Mesa>) Sistema.getInstancia().getMesas();
        Map<Mesa, Comanda> comandas = Sistema.getInstancia().getComandas();

        if (!mesas.contains(mesa))
            throw new MesaInexistenteException(mesa);
        if (!mesa.estaOcupada()) {
            throw new MesaNoOcupadaException(mesa);
        }
        Comanda comanda = comandas.get(mesa);
        Mozo mozo = null;
        boolean encontrado = false;
        Iterator<Map.Entry<Mozo, List<Mesa>>> it = Sistema.getInstancia().getAsignacionMesas().entrySet().iterator();
        while (it.hasNext() && !encontrado) {
            Map.Entry<Mozo, List<Mesa>> entry = it.next();
            if (entry.getValue().contains(mesa)) {
                mozo = entry.getKey();
                encontrado = true;
            }
        }

        comandas.remove(mesa);
        mesa.desocupar();

        assert !comandas.containsKey(mesa) : "La comanda no se cerró";
    }
}
