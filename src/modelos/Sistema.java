package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>Inv:</b>
 * nombreLocal != null
 * nombreLocal != ""
 * mozos != null
 * mesas != null
 * productos != null
 * operarios != null
 * asignacionMesas != null
 * comandas != null
 * promociones != null
 * mozos.size() <= 6
 * Al menos 2 productos deberán estar promocionados (¿Por día?).
 * Se establecen días de promocion para todos los productos.
 * */
public class Sistema {
    private String nombreLocal;
    private List<Mozo> mozos;
    private List<Mesa> mesas;
    private List<Producto> productos;
    private List<Operario> operarios;
    private Map<Mozo, List<Mesa>> asignacionMesas;
    private Map<Mesa, Comanda> comandas;
    private List<Promocion> promociones;

    /**
     * Crea un sistema con en nombre indicado e inicializa las colecciones.
     * <b>Pre:</b>
     * nombreLocal != null
     * nombreLocal != ""
     * <b>post:</b> Se crea el sistema con el nombre indicado y las colecciones vacías.
     * */
    public Sistema(String nombreLocal) {
        assert nombreLocal != null : "El nombre del local no puede ser nulo";
        assert !nombreLocal.equals("") : "El nombre del local no puede ser vacío";

        this.nombreLocal = nombreLocal;

        mozos = new ArrayList<>();
        mesas = new ArrayList<>();
        productos = new ArrayList<>();
        operarios = new ArrayList<>();
        asignacionMesas = new HashMap<>();
        comandas = new HashMap<>();
        promociones = new ArrayList<>();
    }

    /**
     * Agrega un mozo al sistema.
     * <b>Pre:</b>
     * mozo != null
     * mozos.size() < 6
     * <b>Post:</b> Se agrega el mozo al sistema.
     * */
    public void agregarMozo(Mozo mozo) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert mozos.size() < 6 : "No puede haber más de 6 mozos";

        mozos.add(mozo);

        assert mozos.contains(mozo) : "El mozo no se agregó";
    }

    /**
     * Establece el estado de un mozo.
     * <b>Pre:</b>
     * mozo != null
     * estado != null
     * El mozo debe estar en el sistema.
     * <b>Post:</b> Se establece el estado del mozo.
     * */
    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert estado != null : "El estado no puede ser nulo";
        assert mozos.contains(mozo) : "El mozo no está en el sistema";

        mozo.setEstado(estado);

        assert mozo.getEstado() == estado : "El estado no se estableció";
    }

    /**
     * Agrega una mesa al sistema.
     * <b>Pre:</b>
     * mesa != null
     * <b>Post:</b> Se agrega la mesa al sistema.
     * */
    public void agregarMesa(Mesa mesa) {
        assert mesa != null : "La mesa no puede ser nula";

        mesas.stream().filter(m -> m.getNroMesa() == mesa.getNroMesa()).findAny().ifPresent(m -> {
            throw new IllegalArgumentException("Ya existe una mesa con ese número");
        });

        mesas.add(mesa);

        assert mesas.contains(mesa) : "La mesa no se agregó";
    }

    /**
     * Asigna una mesa a un mozo.
     * <b>Pre:</b>
     * mozo != null
     * mesa != null
     * El mozo debe estar en el sistema.
     * La mesa debe estar en el sistema.
     * <b>Post:</b> Se asigna la mesa al mozo.
     * */
    public void asignarMesaAMozo(Mozo mozo, Mesa mesa) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert mesa != null : "La mesa no puede ser nula";
        assert mozos.contains(mozo) : "El mozo no está en el sistema";
        assert mesas.contains(mesa) : "La mesa no está en el sistema";

        asignacionMesas.computeIfAbsent(mozo, k -> new ArrayList<>()).add(mesa);

        assert asignacionMesas.get(mozo).contains(mesa) : "La mesa no se asignó al mozo";
    }
}
