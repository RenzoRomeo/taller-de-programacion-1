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
    private ArrayList<Operario> operarios = new ArrayList<>();
    private Sueldo sueldo;
    private HashMap<Mozo, ArrayList<Mesa>> asignacionMesas = new HashMap<>();
    private HashMap<Mesa, Comanda> comandas = new HashMap<>();
    private ArrayList<Promocion> promociones = new ArrayList<>();

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
        for (Operario operario : operarios) {
            if (operario.getNombreUsuario().equals(nombreUsuario)) {
                if (operario.getContrasenia().equals(contrasenia)) {
                    if (operario.isActivo()) {
                        //TODO: Iniciar sesion
                    } else {
                        throw new UsuarioInactivoException();
                    }
                } else {
                    throw new ContraseniaIncorrectaException();
                }
            }
        }
        throw new UsuarioNoExisteException();
    }



    public void agregarOperario(Operario operario) {
        operarios.add(operario);
    }
    public void eliminarOperario(Operario operario) {
        operarios.remove(operario);
    }
    public void modificarOperario(Operario operario) {
        //TODO
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
    public void modificarMozo(Mozo mozo) {
        //TODO
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
    public void modificarMesa(Mesa mesa) {
        //TODO
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
    public void modificarProducto(Producto producto) {
        //TODO
    }

    //La comanda va estar abierta siempre y cuando exista
    //Se crea con un unico producto y se le van agregando pedidos

    /**
     *
     * @param mesa
     * @param producto
     * @param cantidad
     *
     * <b>Pre:</b>
     * mesa != null
     * producto != null
     * cantidad > 0
     *
     */
    public void crearComanda(Mesa mesa, Producto producto, int cantidad) {
        assert mesa != null;
        assert producto != null;
        assert cantidad > 0;

        Comanda comanda = new Comanda(producto, cantidad);
        comandas.put(mesa, comanda);
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

        Comanda comanda = comandas.get(mesa);
        comanda.cerrarComanda(formaDePago);
        comandas.remove(mesa);
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
