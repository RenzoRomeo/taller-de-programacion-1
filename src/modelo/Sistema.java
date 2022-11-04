package modelo;

import enums.Estado;
import enums.FormaDePago;
import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioNoExisteException;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
    private String nombreLocal;
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private HashMap<String, Operario> operarios = new HashMap<String, Operario>();
    private Sueldo sueldo;
    private HashMap<Mozo, ArrayList<Mesa>> asignacionMesas = new HashMap<>();
    private HashMap<Mesa, Comanda> comandas = new HashMap<>();
    private ArrayList<Promocion> promociones = new ArrayList<>();
    private Administrador administrador;

    //Singleton sistema
    private static Sistema sistema = null;

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    /**
     *
     * @param nombreUsuario
     * @param contrasenia
     *
     * <b>Pre:</b>
     * nombreUsuario != null
     * contrasenia != null
     *
     * <b>Post:</b>
     * //TODO
     *
     */
    public void iniciarSesionOperario(String nombreUsuario, String contrasenia) throws UsuarioInactivoException, UsuarioNoExisteException, ContraseniaIncorrectaException {
        assert nombreUsuario != null;
        assert contrasenia != null;

        if (!operarios.containsKey(nombreUsuario)) {
            throw new UsuarioNoExisteException();
        }
        if(!operarios.get(nombreUsuario).isActivo()) {
            throw new UsuarioInactivoException();
        }
        if(!operarios.get(nombreUsuario).getContrasenia().equals(contrasenia)) {
            throw new ContraseniaIncorrectaException();
        }
        //TODO LOGIN

    }



    public void agregarOperario(Operario operario) {
        operarios.put(operario.getNombreUsuario(), operario);
    }
    public void eliminarOperario(Operario operario) {
        operarios.remove(operario);
    }


    /**
     * Agrega mozo al sistema
     * @param mozo
     * <b>Pre:</b>
     * mozo != null
     *
     */
    public void agregarMozo(Mozo mozo) {
        assert mozo != null;

        mozos.add(mozo);
    }

    /**
     * Elimina mozo del sistema
     * @param mozo
     * <b>Pre:</b>
     * mozo != null
     *
     */
    public void eliminarMozo(Mozo mozo) {
        assert mozo != null;

        mozos.remove(mozo);
    }

    /**
     * establece estado mozo
     * @param mozo
     * @param estado
     * <b>Pre:</b>
     * mozo != null
     * estado != null
     *
     */
    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        assert mozo != null;
        assert estado != null;

        mozo.setEstado(estado);
    }

    /**
     * Agrega mesa al sistema
     * @param mesa
     * <b>Pre:</b>
     * mesa != null
     *
     */
    public void agregarMesa(Mesa mesa) {
        assert mesa != null;

        mesas.add(mesa);
    }

    /**
     * Elimina mesa del sistema
     * @param mesa
     * <b>Pre:</b>
     * mesa != null
     *
     */
    public void eliminarMesa(Mesa mesa) {
        assert mesa != null;

        mesas.remove(mesa);
    }


    /**
     * Agrega producto al sistema
     * @param producto
     * <b>Pre:</b>
     * producto != null
     *
     */
    public void agregarProducto(Producto producto) {
        assert producto != null;

        productos.add(producto);
    }

    /**
     * Elimina producto del sistema
     * @param producto
     * <b>Pre:</b>
     * producto != null
     *
     */
    public void eliminarProducto(Producto producto) {
        assert producto != null;
        productos.remove(producto);
    }

    //La comanda va estar abierta siempre y cuando exista
    //Se crea con un unico producto y se le van agregando pedidos

    /**
     *
     * @param mesa
     *
     * <b>Pre:</b>
     * mesas.size() > 0
     * mesa != null
     * Mesa tiene mozo activo asignado
     * mesa tiene estado libre
     * al menos 2 productos en promocion activa
     *
     */
    public void crearComanda(Mesa mesa, Pedido pedido) {
        assert mesa != null;
        assert mesa.getEstaOcupada() == false;

        //realizar como invariante de clase
        int cantidadPromocion = 0;
        for (Promocion promocion : promociones) {
            if (promocion.estaActiva()) {
                cantidadPromocion++;
            }
        }

        //chequea que la mesa tenga un mozo activo asignado antes de crearla
        int finalCantidadPromocion = cantidadPromocion;
        asignacionMesas.forEach((mozo, mesasAsignadas) -> {
            if (mesasAsignadas.contains(mesa) && mozo.getEstado() == Estado.ACTIVO && finalCantidadPromocion >= 2) {
                        Comanda comanda = new Comanda(pedido);
                        comandas.put(mesa, comanda);
                        mesa.setEstaOcupada(true);
            }
        });


    }

    //Se agrega de a un producto a la comanda

    /**
     *
     * @param p
     * @param cantidad
     * @param mesa
     *
     * <b>Pre:</b>
     * p != null
     * cantidad > 0
     * mesa != null
     *
     */
    public void agregarPedido(Producto p, int cantidad, Mesa mesa) {
        assert p != null;
        assert cantidad > 0;
        assert mesa != null;

        Comanda comanda = comandas.get(mesa);
        comanda.agregarPedido(p, cantidad);
    }

    /**
     *
     * @param mesa
     * @param formaDePago
     *
     * <b>Pre:</b>
     * mesa != null
     * formaDePago != null
     *
     */
    public void cerrarComanda(Mesa mesa, FormaDePago formaDePago) {
        assert mesa != null;
        assert formaDePago != null;

    }

    /**
     *
     * @param mozo
     * @param mesa
     *
     * <b>Pre:</b>
     * mozo != null
     * mozo.getEstado() == Estado.ACTIVO
     * mesa != null
     * mozos.contains(mozo)
     * mesas.contains(mesa)
     *
     *
     * <b>Post:</b>
     * asignacionMesas.get(mozo).contains(mesa)
     *
     */
    public void asignarMesa(Mozo mozo, Mesa mesa) {
        assert mozo != null;
        assert mozo.getEstado() == Estado.ACTIVO;
        assert mesa != null;
        assert mozos.contains(mozo);
        assert mesas.contains(mesa);


        if (asignacionMesas.containsKey(mozo)) {
            if (!asignacionMesas.get(mozo).contains(mesa))
                asignacionMesas.get(mozo).add(mesa);
        }else {
            ArrayList<Mesa> m = new ArrayList<>();
            m.add(mesa);
            asignacionMesas.put(mozo, m);
        }

        assert asignacionMesas.get(mozo).contains(mesa);

    }


    public boolean existeMesa(int nroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNroMesa() == nroMesa) {
                return true;
            }
        }
        return false;
    }
}
