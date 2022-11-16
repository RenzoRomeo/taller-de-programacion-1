package modelo;

//import controladores.LoginController;
import enums.Dia;
import enums.Estado;
import enums.FormaDePago;
import excepciones.*;

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
     * @param nombreUsuario nombre de usuario del operario
     * @param contrasenia contrasenia del operario
     *
     * <br>
     * <b>Pre:</b> <br>
     * nombreUsuario != null <br>
     * contrasenia != null <br>
     *
     * @throws UsuarioInactivoException si el usuario esta inactivo
     * @throws UsuarioNoExisteException si el usuario no existe
     * @throws ContraseniaIncorrectaException si la contrasenia es incorrecta
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
//        LoginController.getInstance().inicioSesionExitoso();

    }


    /**
     * Agrega operario al sistema
     * @param operario
     *
     * <br>
     * <b>Pre:</b> <br>
     * operario != null <br>
     *
     * @throws NombreDeUsuarioNoDisponibleException si el nombre de usuario ya esta en uso
     */
    public void agregarOperario(Operario operario) throws NombreDeUsuarioNoDisponibleException {
        if (operarios.containsKey(operario.getNombreUsuario())) {
            throw new NombreDeUsuarioNoDisponibleException(operario.getNombreUsuario());
        }
        operarios.put(operario.getNombreUsuario(), operario);
    }

    /**
     * Elimina a un operario del sistema
     *
     * @param operario <b>Pre:</b>
     *                 operario != null <br>
     *
     *                 <b>Post:</b>
     *                 Operario eliminado del sistema <br>
     * @throws UsuarioNoExisteException si el usuario no existe
     */
    public void eliminarOperario(Operario operario) throws UsuarioNoExisteException {
        assert operario != null : "El operario no puede ser null";
        if (!operarios.containsKey(operario.getNombreUsuario())) {
            throw new UsuarioNoExisteException();
        }

        operarios.remove(operario);

        assert !operarios.containsKey(operario.getNombreUsuario()) : "El operario no fue eliminado del sistema";
    }


    /**
     * Agrega mozo al sistema
     *
     * @param mozo <br>
     *             <b>Pre:</b> <br>
     *             mozo != null <br>
     *
     *             <b>Post:</b> <br>
     *             mozo cargado en el sistema <br>
     * @throws MozoYaExistenteException si el mozo ya existe
     */
    public void agregarMozo(Mozo mozo) throws MozoYaExistenteException {
        assert mozo != null : "El mozo no puede ser null";

        if (mozos.contains(mozo)) {
            throw new MozoYaExistenteException();
        }

        mozos.add(mozo);

        assert mozos.contains(mozo) : "El mozo no fue cargado en el sistema";
    }

    /**
     * Elimina mozo del sistema
     *
     * @param mozo <b>Pre:</b>
     *             mozo != null <br>
     *             mozo esta cargado en el sistema <br>
     *
     *             <b>Post:</b>
     *             mozo eliminado del sistema <br>
     * @throws MozoNoExisteException si el mozo no existe
     */
    public void eliminarMozo(Mozo mozo) throws MozoNoExisteException {
        assert mozo != null;

        if (!mozos.contains(mozo)) {
            throw new MozoNoExisteException();
        }

        mozos.remove(mozo);
    }

    /**
     * establece estado mozo
     *
     * @param mozo   mozo a modificar
     * @param estado estado a establecer
     *               <b>Pre:</b>
     *               mozo != null
     *               estado != null
     * @throws MozoNoExisteException       si el mozo no existe
     * @throws EstadoMozoInvalidoException si el estado es invalido
     */
    public void establecerEstadoMozo(Mozo mozo, Estado estado) throws MozoNoExisteException, EstadoMozoInvalidoException {
        assert mozo != null;
        assert estado != null;

        if (!mozos.contains(mozo)) {
            throw new MozoNoExisteException();
        }
        if (estado != Estado.ACTIVO || estado != Estado.AUSENTE || estado != Estado.DE_FRANCO) {
            throw new EstadoMozoInvalidoException();
        }

        mozo.setEstado(estado);
    }

    /**
     * Agrega mesa al sistema
     *
     * @param mesa <br>
     *             <b>Pre:</b> <br>
     *             mesa != null <br>
     *
     *             <b>Post:</b> <br>
     *             mesa cargada en el sistema <br>
     * @throws MesaYaExistenteException si la mesa ya existe
     */
    public void agregarMesa(Mesa mesa) throws MesaYaExistenteException {
        assert mesa != null : "La mesa no puede ser null";

        if (mesas.contains(mesa)) {
            throw new MesaYaExistenteException();
        }

        mesas.add(mesa);

        assert mesas.contains(mesa) : "La mesa no fue cargada en el sistema";
    }

    /**
     * Elimina mesa del sistema
     *
     * @param mesa <br>
     *             <b>Pre:</b> <br>
     *             mesa != null <br>
     *
     *             <b>Post:</b> <br>
     *             mesa eliminada del sistema <br>
     * @throws MesaNoExisteException si la mesa no existe
     */
    public void eliminarMesa(Mesa mesa) throws MesaNoExisteException {
        assert mesa != null : "La mesa no puede ser null";

        if (!mesas.contains(mesa)) {
            throw new MesaNoExisteException();
        }
        mesas.remove(mesa);

        assert !mesas.contains(mesa) : "La mesa no fue eliminada del sistema";
    }


    /**
     * Agrega producto al sistema
     *
     * @param producto <b>Pre:</b>
     *                 producto != null
     * @throws ProductoYaExistenteException si el producto ya existe
     */
    public void agregarProducto(Producto producto) throws ProductoYaExistenteException {
        assert producto != null;

        if (productos.contains(producto)) {
            throw new ProductoYaExistenteException();
        }
        productos.add(producto);
    }

    /**
     * Elimina producto del sistema
     *
     * @param producto <br>
     *                 <b>Pre:</b> <br>
     *                 producto != null <br>
     *
     *                 <b>Post:</b>
     *                 producto eliminado del sistema <br>
     * @throws ProductoNoExisteException si el producto no existe
     */

    public void eliminarProducto(Producto producto) throws ProductoNoExisteException {
        assert producto != null : "El producto no puede ser null";
        assert productos.contains(producto) : "El producto no esta cargado en el sistema";

        if (!productos.contains(producto)) {
            throw new ProductoNoExisteException();
        }

        productos.remove(producto);

        assert !productos.contains(producto) : "El producto no fue eliminado del sistema";
    }

    //La comanda va estar abierta siempre y cuando exista
    //Se crea con un unico producto y se le van agregando pedidos

    /**
     * @param mesa     mesa a la que se le agrega la comanda
     * @param p        producto a agregar a la comanda
     * @param cantidad cantidad del producto a agregar
     *
     *                 <br>
     *                 <b>Pre:</b> <br>
     *                 mesa != null <br>
     *                 Mesa tiene mozo activo asignado <br>
     *
     *                 <b>Post:</b> <br>
     *                 comanda creada <br>
     * @throws MesaNoExisteException             si la mesa no existe
     * @throws MesaNoDisponibleException         si la mesa esta ocupada
     * @throws ProductoNoExisteException         si el producto no existe
     * @throws ProductoNoDisponibleException     si el producto no tiene stock solicitado
     * @throws CantidadEnPromocionMenorException si la cantidad es menor a 2
     */
    public void crearComanda(Mesa mesa, Producto p, int cantidad) throws MesaNoExisteException, MesaNoDisponibleException, ProductoNoExisteException, ProductoNoDisponibleException, CantidadEnPromocionMenorException {
        assert mesa != null : "La mesa no puede ser null";

        if (!mesas.contains(mesa)) {
            throw new MesaNoExisteException();
        }
        if (mesa.getEstaOcupada()) {
            throw new MesaNoDisponibleException();
        }
        if (!productos.contains(p)) {
            throw new ProductoNoExisteException();
        }
        if ((p.getStock() - cantidad) <= 0) {
            throw new ProductoNoDisponibleException();
        }

        //chequea cuantos productos hay en promocion hoy
        int cantidadPromocion = 0;
        for (PromocionProducto promocion : promocionesProducto) {
            if (promocion.estaActiva() && cumpleDiaPromocion(promocion)) {
                cantidadPromocion++;
            }
        }
        if (cantidadPromocion < 2) {
            throw new CantidadEnPromocionMenorException();
        }

        //chequea que la mesa tenga un mozo activo asignado antes de crearla
        asignacionMesas.forEach((mozo, mesasAsignadas) -> {
            if (mesasAsignadas.contains(mesa) && mozo.getEstado() == Estado.ACTIVO) {
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
     * @param p        producto a agregar a la comanda
     * @param cantidad cantidad del producto a agregar
     * @param mesa     mesa a la que se le agrega el pedido
     *
     *                 <br>
     *                 <b>Pre:</b> <br>
     *                 p != null <br>
     *                 cantidad mayor a 0 <br>
     *                 mesa != null <br>
     *
     *                 <b>Post:</b> <br>
     *                 pedido agregado a la comanda <br>
     * @throws ProductoNoExisteException     si el producto no existe
     * @throws ProductoNoDisponibleException si el producto no tiene stock solicitado
     * @throws MesaNoExisteException         si la mesa no existe
     * @throws MesaNoTieneComandaException   si la mesa no tiene comanda creada
     */
    public void agregarPedido(Producto p, int cantidad, Mesa mesa) throws ProductoNoExisteException, ProductoNoDisponibleException, MesaNoExisteException, MesaNoTieneComandaException {
        assert p != null : "El producto no puede ser null";
        assert cantidad > 0 : "La cantidad debe ser mayor a 0";
        assert mesa != null : "La mesa no puede ser null";

        if (!productos.contains(p)) {
            throw new ProductoNoExisteException();
        }
        if ((p.getStock() - cantidad) <= 0) {
            throw new ProductoNoDisponibleException();
        }
        if (!mesas.contains(mesa)) {
            throw new MesaNoExisteException();
        }
        if (!comandas.containsKey(mesa)) {
            throw new MesaNoTieneComandaException();
        }

        Comanda comanda = comandas.get(mesa);
        comanda.agregarPedido(p, cantidad);

        assert comanda.getPedidos().contains(p) : "El pedido no fue agregado a la comanda";
    }

    /**
     * @param mesa        mesa a la que se le cierra la comanda
     * @param formaDePago forma de pago de la comanda
     *
     *                    <br>
     *                    <b>Pre:</b> <br>
     *                    mesa != null <br>
     *                    formaDePago != null <br>
     *
     *                    <b>Post:</b> <br>
     *                    comanda cerrada <br>
     * @throws MesaNoExisteException        si la mesa no existe
     * @throws MesaNoTieneComandaException  si la mesa no tiene comanda creada
     * @throws FormaDePagoInvalidaException si la forma de pago no es valida
     */
    public void cerrarComanda(Mesa mesa, FormaDePago formaDePago) throws MesaNoExisteException, MesaNoTieneComandaException, FormaDePagoInvalidaException {
        assert mesa != null : "La mesa no puede ser null";
        assert formaDePago != null : "La forma de pago no puede ser null";

        if (!mesas.contains(mesa)) {
            throw new MesaNoExisteException();
        }
        if (!comandas.containsKey(mesa)) {
            throw new MesaNoTieneComandaException();
        }
        if (!(formaDePago == FormaDePago.TARJETA || formaDePago == FormaDePago.EFECTIVO)) {
            throw new FormaDePagoInvalidaException();
        }

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
        } else if (!aplicoPromocionProducto) {
            auxiliar = true;
        }
        return auxiliar;
    }


    private boolean cumpleDiaPromocion(Promocion promocion) {
        return promocion.getDiasPromo().contains(Dia.getDiaActual());
    }


    /**
     * @param mozo mozo a asignar a la mesa
     * @param mesa mesa a la que se le asigna el mozo
     *
     *             <br>
     *             <b>Pre:</b> <br>
     *             mozo != null <br>
     *             mozo.getEstado() == Estado.ACTIVO <br>
     *             mesa != null <br>
     *             mozos.contains(mozo) <br>
     *             mesas.contains(mesa) <br>
     *
     *
     *             <b>Post:</b> <br>
     *             asignacionMesas.get(mozo).contains(mesa) <br>
     */
    public void asignarMesa(Mozo mozo, Mesa mesa) throws MozoNoExisteException, MesaNoExisteException, MozoNoActivoException {
        assert mozo != null : "Mozo no puede ser null";
        assert mesa != null : "Mesa no puede ser null";

        if (!mozos.contains(mozo)) {
            throw new MozoNoExisteException();
        }
        if (!mesas.contains(mesa)) {
            throw new MesaNoExisteException();
        }
        if (mozo.getEstado() != Estado.ACTIVO) {
            throw new MozoNoActivoException();
        }


        if (asignacionMesas.containsKey(mozo)) {
            if (!asignacionMesas.get(mozo).contains(mesa))
                asignacionMesas.get(mozo).add(mesa);
        } else {
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
     * @param id id de la promocion
     * @param activa indica si la promocion esta activa
     * @param diasPromo dias en los que se aplica la promocion
     * @param producto producto al que se le aplica la promocion
     * @param aplicaDosPorUno indica si la promocion es 2x1
     * @param aplicaDescuentoPorCantidad indica si la promocion es por descuento por cantidad
     * @param dtoPorCantidad_CantMinima cantidad minima para aplicar el descuento por cantidad
     * @param descuentoPorCantidad_PrecioUnitario precio unitario para aplicar el descuento por cantidad
     *
     * <br>
     * <b>Post:</b> <br>
     * Se agrega promocion al sistema <br>
     *
     * @throws ProductoNoExisteException si el producto no existe en el sistema
     */
    public void agregarPromocionProducto(int id, boolean activa, ArrayList<Dia> diasPromo, Producto producto, boolean aplicaDosPorUno, boolean aplicaDescuentoPorCantidad, int dtoPorCantidad_CantMinima, double descuentoPorCantidad_PrecioUnitario) throws ProductoNoExisteException {

        if (!productos.contains(producto)) {
            throw new ProductoNoExisteException();
        }

        PromocionProducto promocion = new PromocionProducto(id, diasPromo, producto, aplicaDosPorUno, aplicaDescuentoPorCantidad, dtoPorCantidad_CantMinima, descuentoPorCantidad_PrecioUnitario);
        promocionesProducto.add(promocion);

        assert promocionesProducto.contains(promocion) : "Promocion no agregada";
    }

    /**
     * Agrega una promocion temporal al sistema
     * @param id id de la promocion
     * @param activa indica si la promocion esta activa
     * @param diasPromo dias en los que se aplica la promocion
     * @param nombre nombre de la promocion
     * @param formaDePago forma de pago para aplicar la promocion
     * @param porcentajeDescuento porcentaje de descuento a aplicar
     * @param esAcumulable indica si la promocion es acumulable
     *
     * <br>
     *
     * <b>Post:</b> <br>
     * Se agrega promocion al sistema <br>
     *
     * @throws FormaDePagoInvalidaException si la forma de pago no es valida
     */
    public void agregarPromocionTemporal(int id, boolean activa, ArrayList<Dia> diasPromo, String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable) throws FormaDePagoInvalidaException{

        if (!(formaDePago == FormaDePago.EFECTIVO || formaDePago == FormaDePago.TARJETA)) {
            throw new FormaDePagoInvalidaException();
        }

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