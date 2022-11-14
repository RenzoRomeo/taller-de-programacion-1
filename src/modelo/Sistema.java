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

    /**
     * Patron singleton para obtener una instancia de sistema <br>
     *
     * @return instancia de sistema
     */
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
     * Inicio de sesion de un operario
     * @param nombreUsuario
     * @param contrasenia
     *
     * <br>
     * <b>Pre:</b> <br>
     * nombreUsuario != null <br>
     * contrasenia != null <br>
     *
     * @throws UsuarioInactivoException
     * @throws UsuarioNoExisteException
     * @throws ContraseniaIncorrectaException
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


    /**
     * Agrega operario al sistema
     * @param operario
     *
     * <br>
     * <b>Pre:</b> <br>
     * operario != null <br>
     *
     * @throws NombreDeUsuarioNoDisponibleException
     */
    public void agregarOperario(Operario operario) throws NombreDeUsuarioNoDisponibleException {
        if (operarios.containsKey(operario.getNombreUsuario())) {
            throw new NombreDeUsuarioNoDisponibleException(operario.getNombreUsuario());
        }
        operarios.put(operario.getNombreUsuario(), operario);
    }

    /**
     * Elimina a un operario del sistema
     * @param operario
     *
     * <b>Pre:</b>
     * operario != null <br>
     * Operario esta cargado en el sistema <br>
     *
     * <b>Post:</b>
     * Operario eliminado del sistema <br>
     */
    public void eliminarOperario(Operario operario) {
        assert operario != null : "El operario no puede ser null";
        assert operarios.containsKey(operario.getNombreUsuario()) : "El operario no esta cargado en el sistema";

        operarios.remove(operario);

        assert !operarios.containsKey(operario.getNombreUsuario()) : "El operario no fue eliminado del sistema";
    }


    /**
     * Agrega mozo al sistema
     * @param mozo
     * <b>Pre:</b>
     * mozo != null
     * mozo no esta cargado en el sistema
     *
     * <b>Post:</b>
     * mozo cargado en el sistema
     */
    public void agregarMozo(Mozo mozo) {
        assert mozo != null : "El mozo no puede ser null";
        assert !mozos.contains(mozo) : "El mozo ya esta cargado en el sistema";

        mozos.add(mozo);

        assert mozos.contains(mozo) : "El mozo no fue cargado en el sistema";
    }

    /**
     * Elimina mozo del sistema
     * @param mozo
     * <b>Pre:</b>
     * mozo != null <br>
     * mozo esta cargado en el sistema <br>
     *
     * <b>Post:</b>
     * mozo eliminado del sistema <br>
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
     * <br>
     * <b>Pre:</b> <br>
     * mesa != null <br>
     * mesa no esta cargada en el sistema <br>
     *
     * <b>Post:</b> <br>
     * mesa cargada en el sistema <br>
     */
    public void agregarMesa(Mesa mesa) {
        assert mesa != null : "La mesa no puede ser null";
        assert !mesas.contains(mesa) : "La mesa ya esta cargada en el sistema";

        mesas.add(mesa);

        assert mesas.contains(mesa) : "La mesa no fue cargada en el sistema";
    }

    /**
     * Elimina mesa del sistema
     * @param mesa
     * <br>
     * <b>Pre:</b> <br>
     * mesa != null <br>
     * mesa esta cargada en el sistema <br>
     *
     * <b>Post:</b> <br>
     * mesa eliminada del sistema <br>
     */
    public void eliminarMesa(Mesa mesa) {
        assert mesa != null : "La mesa no puede ser null";
        assert mesas.contains(mesa) : "La mesa no esta cargada en el sistema";

        mesas.remove(mesa);

        assert !mesas.contains(mesa) : "La mesa no fue eliminada del sistema";
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
     * <br>
     * <b>Pre:</b> <br>
     * producto != null <br>
     * producto esta cargado en el sistema <br>
     *
     * <b>Post:</b>
     * producto eliminado del sistema <br>
     */

    public void eliminarProducto(Producto producto) {
        assert producto != null : "El producto no puede ser null";
        assert productos.contains(producto) : "El producto no esta cargado en el sistema";

        productos.remove(producto);

        assert !productos.contains(producto) : "El producto no fue eliminado del sistema";
    }

    //La comanda va estar abierta siempre y cuando exista
    //Se crea con un unico producto y se le van agregando pedidos

    /**
     *
     * @param mesa
     * @param p
     * @param cantidad
     *
     * <br>
     * <b>Pre:</b> <br>
     * mesas.size() > 0 <br>
     * mesa != null <br>
     * Mesa tiene mozo activo asignado <br>
     * mesa tiene estado libre <br>
     * al menos 2 productos en promocion activa <br>
     *
     * <b>Post:</b> <br>
     * comanda creada <br>
     *
     */
    public void crearComanda(Mesa mesa, Producto p, int cantidad) {
        assert mesa != null : "La mesa no puede ser null";
        assert mesa.getEstaOcupada() == false : "La mesa no esta libre";

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
                Comanda comanda = new Comanda();
                comanda.agregarPedido(p, cantidad);
                comandas.put(mesa, comanda);
                mesa.setEstaOcupada(true);
            }
        });

        assert comandas.containsKey(mesa) : "La comanda no fue creada";
    }

    //Se agrega de a un producto a la comanda

    /**
     *
     * @param p
     * @param cantidad
     * @param mesa
     *
     * <br>
     * <b>Pre:</b> <br>
     * p != null <br>
     * cantidad > 0 <br>
     * mesa != null <br>
     * mesa esta cargada en el sistema <br>
     * mesa tiene comanda abierta <br>
     *
     * <b>Post:</b> <br>
     * pedido agregado a la comanda <br>
     */
    public void agregarPedido(Producto p, int cantidad, Mesa mesa) {
        assert p != null : "El producto no puede ser null";
        assert cantidad > 0 : "La cantidad debe ser mayor a 0";
        assert mesa != null : "La mesa no puede ser null";
        assert mesas.contains(mesa) : "La mesa no esta cargada en el sistema";
        assert comandas.containsKey(mesa) : "La mesa no tiene comanda abierta";

        Comanda comanda = comandas.get(mesa);
        comanda.agregarPedido(p, cantidad);

        assert comanda.getPedidos().contains(p) : "El pedido no fue agregado a la comanda";
    }

    /**
     *
     * @param mesa
     * @param formaDePago
     *
     * <br>
     * <b>Pre:</b> <br>
     * mesa != null <br>
     * mesa esta cargada en el sistema <br>
     * mesa tiene comanda abierta <br>
     * formaDePago != null <br>
     *
     * <b>Post:</b> <br>
     *  comanda cerrada <br>
     */
    public void cerrarComanda(Mesa mesa, FormaDePago formaDePago) {
        assert mesa != null : "La mesa no puede ser null";
        assert mesas.contains(mesa) : "La mesa no esta cargada en el sistema";
        assert comandas.containsKey(mesa) : "La mesa no tiene comanda abierta";
        assert formaDePago != null : "La forma de pago no puede ser null";

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

        assert !comandas.containsKey(mesa) : "La comanda no fue cerrada";

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
     * <br>
     * <b>Pre:</b> <br>
     * mozo != null <br>
     * mozo.getEstado() == Estado.ACTIVO <br>
     * mesa != null <br>
     * mozos.contains(mozo) <br>
     * mesas.contains(mesa) <br>
     *
     *
     * <b>Post:</b> <br>
     * asignacionMesas.get(mozo).contains(mesa) <br>
     */
    public void asignarMesa(Mozo mozo, Mesa mesa) {
        assert mozo != null : "Mozo no puede ser null";
        assert mozo.getEstado() == Estado.ACTIVO : "Mozo debe estar activo";
        assert mesa != null : "Mesa no puede ser null";
        assert mozos.contains(mozo) : "Mozo no existe";
        assert mesas.contains(mesa) : "Mesa no existe";


        if (asignacionMesas.containsKey(mozo)) {
            if (!asignacionMesas.get(mozo).contains(mesa))
                asignacionMesas.get(mozo).add(mesa);
        }else {
            ArrayList<Mesa> m = new ArrayList<>();
            m.add(mesa);
            asignacionMesas.put(mozo, m);
        }

        assert asignacionMesas.get(mozo).contains(mesa) : "Mesa no asignada correctamente";
    }


    public boolean existeMesa(int nroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNroMesa() == nroMesa) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega una promocion de producto al sistema
     * @param id
     * @param activa
     * @param diasPromo
     * @param producto
     * @param aplicaDosPorUno
     * @param aplicaDescuentoPorCantidad
     * @param dtoPorCantidad_CantMinima
     * @param descuentoPorCantidad_PrecioUnitario
     *
     * <br>
     * <b>Post:</b> <br>
     * Se agrega promocion al sistema <br>
     */
    public void agregarPromocionProducto(int id, boolean activa, ArrayList<Dia> diasPromo, Producto producto, boolean aplicaDosPorUno, boolean aplicaDescuentoPorCantidad, int dtoPorCantidad_CantMinima, double descuentoPorCantidad_PrecioUnitario) {
        PromocionProducto promocion = new PromocionProducto(id, diasPromo, producto, aplicaDosPorUno, aplicaDescuentoPorCantidad, dtoPorCantidad_CantMinima, descuentoPorCantidad_PrecioUnitario);
        promocionesProducto.add(promocion);

        assert promocionesProducto.contains(promocion) : "Promocion no agregada";
    }

    /**
     * Agrega una promocion temporal al sistema
     * @param id
     * @param activa
     * @param diasPromo
     * @param nombre
     * @param formaDePago
     * @param porcentajeDescuento
     * @param esAcumulable
     *
     * <br>
     * <b>Post:</b> <br>
     * Se agrega promocion al sistema <br>
     */
    public void agregarPromocionTemporal(int id, boolean activa, ArrayList<Dia> diasPromo, String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable){
        PromocionTemporal promocion = new PromocionTemporal(id, diasPromo, nombre, formaDePago, porcentajeDescuento, esAcumulable);
        promocionesTemporales.add(promocion);

        assert promocionesTemporales.contains(promocion) : "Promocion no agregada";
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