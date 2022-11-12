package modelo;

import controladores.LoginController;
import enums.Dia;
import enums.Estado;
import enums.FormaDePago;
import excepciones.ContraseniaIncorrectaException;
import excepciones.NombreDeUsuarioNoDisponibleException;
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
    private ArrayList<PromocionProducto> promocionesProducto = new ArrayList<>();
    private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();
    private Administrador administrador;


    private Sistema() {
        this.administrador = new Administrador();
    }

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
        LoginController.getInstance().inicioSesionExitoso();

    }



    public void agregarOperario(Operario operario) throws NombreDeUsuarioNoDisponibleException {
        if (operarios.containsKey(operario.getNombreUsuario())) {
            throw new NombreDeUsuarioNoDisponibleException(operario.getNombreUsuario());
        }
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

        //chequea cuantos productos hay en promocion hoy
        int cantidadPromocion = 0;
        for (PromocionProducto promocion : promocionesProducto) {
            if (promocion.estaActiva() && cumpleDiaPromocion(promocion)) {
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

        Comanda comanda = comandas.get(mesa);
        Mozo mozo = null;
        for (HashMap.Entry<Mozo, ArrayList<Mesa>> entry : asignacionMesas.entrySet()) {
            if (entry.getValue().contains(mesa)) {
                mozo = entry.getKey();
            }
        }

        ArrayList<Promocion> promocionesAplicadas = new ArrayList<>();
        ArrayList<Pedido> pedidos = comanda.getPedidos();
        double total = 0.0;
        double subtotal = 0.0;
        boolean aplicoPromocionProducto = false;

        for (Pedido pedido : pedidos) {
                Producto producto = pedido.getProducto();
                //chequeo si producto esta en promocion
                for (PromocionProducto promocionProducto : promocionesProducto) {
                    subtotal = promocionProducto.getProducto().getPrecioVenta() * pedido.getCantidad();
                    if (promocionProducto.getProducto().equals(producto) && promocionProducto.estaActiva() && cumpleDiaPromocion(promocionProducto)) {
                        aplicoPromocionProducto = true;
                        promocionesAplicadas.add(promocionProducto);
                        total += promocionProducto.realizaDescuento(pedido, subtotal);
                    }
                    else {
                        total += subtotal;
                    }
                }
                //chequeo si hay promocion temporal
                for (PromocionTemporal promocionTemporal : promocionesTemporales) {
                    if (promocionTemporal.estaActiva() && cumpleDiaPromocion(promocionTemporal) && cumpleCondicionAcumulable(promocionTemporal.esAcumulable(), aplicoPromocionProducto) && promocionTemporal.getFormaDePago().equals(formaDePago)) {
                        promocionesAplicadas.add(promocionTemporal);
                        total += promocionTemporal.realizaDescuento(total);
                    }
                }
            }
        Factura factura = new Factura(mesa, formaDePago, total, promocionesAplicadas, mozo);
    }

    private boolean cumpleCondicionAcumulable(boolean esAcumulable, boolean aplicoPromocionProducto) {
        boolean auxiliar = false;
        if (esAcumulable) {
            auxiliar = true;
        }
        else if (!aplicoPromocionProducto) {
            auxiliar = true;
        }
        return auxiliar;
    }


    private boolean cumpleDiaPromocion(Promocion promocion) {
        return promocion.getDiasPromo().contains(Dia.getDiaActual());
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

    public void agregarPromocionProducto(int id, boolean activa, ArrayList<Dia> diasPromo, Producto producto, boolean aplicaDosPorUno, boolean aplicaDescuentoPorCantidad, int dtoPorCantidad_CantMinima, double descuentoPorCantidad_PrecioUnitario) {
        PromocionProducto promocion = new PromocionProducto(id, activa, diasPromo, producto, aplicaDosPorUno, aplicaDescuentoPorCantidad, dtoPorCantidad_CantMinima, descuentoPorCantidad_PrecioUnitario);
        promocionesProducto.add(promocion);
    }

    public void agregarPromocionTemporal(int id, boolean activa, ArrayList<Dia> diasPromo, String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable){
        PromocionTemporal promocion = new PromocionTemporal(id, activa, diasPromo, nombre, formaDePago, porcentajeDescuento, esAcumulable);
        promocionesTemporales.add(promocion);
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public HashMap<String, Operario> getOperarios() {
        return operarios;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public HashMap<Mozo, ArrayList<Mesa>> getAsignacionMesas() {
        return asignacionMesas;
    }

    public HashMap<Mesa, Comanda> getComandas() {
        return comandas;
    }

    public ArrayList<PromocionProducto> getPromocionesProducto() {
        return promocionesProducto;
    }

    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setOperarios(HashMap<String, Operario> operarios) {
        this.operarios = operarios;
    }

    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
    }

    public void setAsignacionMesas(HashMap<Mozo, ArrayList<Mesa>> asignacionMesas) {
        this.asignacionMesas = asignacionMesas;
    }

    public void setComandas(HashMap<Mesa, Comanda> comandas) {
        this.comandas = comandas;
    }

    public void setPromocionesProducto(ArrayList<PromocionProducto> promocionesProducto) {
        this.promocionesProducto = promocionesProducto;
    }

    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public static void setSistema(Sistema sistema) {
        Sistema.sistema = sistema;
    }
}