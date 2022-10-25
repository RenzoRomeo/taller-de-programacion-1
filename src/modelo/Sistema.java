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

    public void agregarMozo(Mozo mozo) {
        mozos.add(mozo);
    }
    public void eliminarMozo(Mozo mozo) {
        mozos.remove(mozo);
    }
    public void modificarMozo(Mozo mozo) {
        //TODO
    }

    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        mozo.setEstado(estado);
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
    public void eliminarMesa(Mesa mesa) {
        mesas.remove(mesa);
    }
    public void modificarMesa(Mesa mesa) {
        //TODO
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
    public void modificarProducto(Producto producto) {
        //TODO
    }

    public void crearComanda(Mesa mesa) {
        Comanda comanda = new Comanda();
        comandas.put(mesa, comanda);
    }
    public void agregarPedido(Pedido pedido, Mesa mesa) {
        Comanda comanda = comandas.get(mesa);
        comanda.agregarPedido(pedido);
    }
    public void cerrarComanda(Mesa mesa, FormaDePago formaDePago) {
        Comanda comanda = comandas.get(mesa);
        comanda.cerrarComanda(formaDePago);
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


}
