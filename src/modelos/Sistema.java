package modelos;

import excepciones.AdministradorExistenteException;
import excepciones.MesaRepetidaException;
import excepciones.OperarioExistenteException;
import excepciones.SistemaYaInicializadoException;
import modelos.enums.Dia;
import modelos.enums.Estado;
import modelos.enums.ModoOperacion;

import java.util.*;

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
 * Al menos 2 productos deberán estar promocionados.
 * Se establecen días de promocion para todos los productos.
 */
public class Sistema {
    private String nombreLocal;
    private List<Mozo> mozos;
    private List<Mesa> mesas;
    private List<Producto> productos;
    private List<Operario> operarios;
    private Map<Mozo, List<Mesa>> asignacionMesas;
    private Map<Mesa, Comanda> comandas;
    private Map<Producto, List<Promocion>> promociones;
    private Administrador administrador;
    private ModoOperacion modoOperacion;

    private static Sistema instancia = null;

    private Sistema() {

    }

    /**
     * Devuelve la instancia del sistema.
     * <b>Pre:</b>
     * El sistema ya fue inicializado.
     *
     * @return Instancia del sistema.
     */
    public static Sistema getInstancia() {
        assert isInicializado() : "El sistema no ha sido inicializado";
        return instancia;
    }

    /**
     * Devuelve verdadero si el sistema ya fue inicializado.
     *
     * @return Si el sistema ya fue inicializado.
     */
    public static boolean isInicializado() {
        return instancia != null;
    }

    /**
     * Inicializa el sistema con en nombre indicado y sus colecciones.
     *
     * @param nombreLocal Nombre del local.
     *                    <b>Pre:</b>
     *                    nombreLocal != null
     *                    nombreLocal != ""
     *                    <b>post:</b> Se crea el sistema con el nombre indicado y las colecciones vacías.
     * @throws SistemaYaInicializadoException  si el sistema ya fue inicializado.
     * @throws AdministradorExistenteException si el sistema ya tiene un administrador.
     */
    public static void inicializarSistema(String nombreLocal) throws SistemaYaInicializadoException, AdministradorExistenteException {
        assert nombreLocal != null : "El nombre del local no puede ser nulo";
        assert !nombreLocal.equals("") : "El nombre del local no puede ser vacío";

        if (instancia != null) {
            throw new SistemaYaInicializadoException();
        }

        instancia = new Sistema();

        instancia.nombreLocal = nombreLocal;
        instancia.mozos = new ArrayList<>();
        instancia.mesas = new ArrayList<>();
        instancia.productos = new ArrayList<>();
        instancia.operarios = new ArrayList<>();
        instancia.asignacionMesas = new HashMap<>();
        instancia.comandas = new HashMap<>();
        instancia.promociones = new HashMap<>();
        instancia.administrador = Administrador.crearAdministrador();
        instancia.modoOperacion = ModoOperacion.OPERARIO;

        assert instancia.nombreLocal == nombreLocal : "El nombre del local no se asignó correctamente";
        assert instancia.mozos != null : "La lista de mozos no se inicializó correctamente";
        assert instancia.mesas != null : "La lista de mesas no se inicializó correctamente";
        assert instancia.productos != null : "La lista de productos no se inicializó correctamente";
        assert instancia.operarios != null : "La lista de operarios no se inicializó correctamente";
        assert instancia.asignacionMesas != null : "La asignación de mesas no se inicializó correctamente";
        assert instancia.comandas != null : "La lista de comandas no se inicializó correctamente";
        assert instancia.promociones != null : "La lista de promociones no se inicializó correctamente";
        assert instancia.administrador != null : "El administrador no se inicializó correctamente";
        assert instancia.modoOperacion == ModoOperacion.OPERARIO : "El modo administrador no se inicializó correctamente";

        assert instancia.verificarInvariantes() : "No se cumple la invariante";
    }

    /**
     * Agrega un mozo al sistema.
     * <b>Pre:</b>
     * mozo != null
     * <b>Post:</b> Se agrega el mozo al sistema.
     */
    public void agregarMozo(Mozo mozo) {
        assert mozo != null : "El mozo no puede ser nulo";

        mozos.add(mozo);

        assert mozos.contains(mozo) : "El mozo no se agregó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Elimina un mozo del sistema.
     * <b>Pre:</b>
     * mozo != null
     * El mozo debe estar en el sistema.
     * <b>Post:</b> Se elimina el mozo del sistema.
     */
    public void eliminarMozo(Mozo mozo) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert mozos.contains(mozo) : "El mozo no se encuentra en el sistema";

        mozos.remove(mozo);

        assert !mozos.contains(mozo) : "El mozo no se eliminó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Agrega un producto al sistema.
     * <b>Pre:</b>
     * producto != null
     * El producto no debe estar en el sistema.
     * <b>Post:</b> Se agrega el producto al sistema.
     */
    public void agregarProducto(Producto producto) {
        assert producto != null : "El producto no puede ser nulo";
        assert !productos.contains(producto) : "El producto ya se encuentra en el sistema";

        productos.add(producto);

        assert productos.contains(producto) : "El producto no se agregó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Elimina un producto del sistema.
     * <b>Pre:</b>
     * producto != null
     * El producto debe estar en el sistema.
     * <b>Post:</b> Se elimina el producto del sistema.
     */
    public void eliminarProducto(Producto producto) {
        assert producto != null : "El producto no puede ser nulo";
        assert productos.contains(producto) : "El producto no se encuentra en el sistema";

        productos.remove(producto);

        assert !productos.contains(producto) : "El producto no se eliminó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Establece el estado de un mozo.
     * <b>Pre:</b>
     * mozo != null
     * estado != null
     * El mozo debe estar en el sistema.
     * <b>Post:</b> Se establece el estado del mozo.
     */
    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert estado != null : "El estado no puede ser nulo";
        assert mozos.contains(mozo) : "El mozo no está en el sistema";

        mozo.setEstado(estado);

        assert mozo.getEstado() == estado : "El estado no se estableció";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Agrega una mesa al sistema.
     * <b>Pre:</b>
     * mesa != null
     * <b>Post:</b> Se agrega la mesa al sistema.
     * @throws MesaRepetidaException si la mesa ya está en el sistema.
     */
    public void agregarMesa(Mesa mesa) throws MesaRepetidaException {
        assert mesa != null : "La mesa no puede ser nula";

        if (mesas.stream().anyMatch(m -> m.getNroMesa() == mesa.getNroMesa())) {
            throw new MesaRepetidaException();
        }

        mesas.add(mesa);

        assert mesas.contains(mesa) : "La mesa no se agregó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Elimina una mesa del sistema.
     * <b>Pre:</b>
     * mesa != null
     * La mesa debe estar en el sistema.
     * <b>Post:</b> Se elimina la mesa del sistema.
     */
    public void eliminarMesa(Mesa mesa) {
        assert mesa != null : "La mesa no puede ser nula";
        assert mesas.contains(mesa) : "La mesa no está en el sistema";

        mesas.remove(mesa);

        assert !mesas.contains(mesa) : "La mesa no se eliminó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Asigna una mesa a un mozo.
     * <b>Pre:</b>
     * mozo != null
     * mesa != null
     * El mozo debe estar en el sistema.
     * La mesa debe estar en el sistema.
     * <b>Post:</b> Se asigna la mesa al mozo.
     */
    public void asignarMesa(Mozo mozo, Mesa mesa) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert mesa != null : "La mesa no puede ser nula";
        assert mozos.contains(mozo) : "El mozo no está en el sistema";
        assert mesas.contains(mesa) : "La mesa no está en el sistema";

        asignacionMesas.computeIfAbsent(mozo, k -> new ArrayList<>()).add(mesa);

        assert asignacionMesas.get(mozo).contains(mesa) : "La mesa no se asignó al mozo";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Crea una comanda para una mesa.
     * <b>Pre:</b>
     */
    public void crearComanda(Mesa mesa) {
        assert mesa != null : "La mesa no puede ser nula";
        assert mesas.contains(mesa) : "La mesa no está en el sistema";

        comandas.put(mesa, new Comanda());

        assert comandas.containsKey(mesa) : "La comanda no se creó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    /**
     * Agrega un operario al sistema.
     * <b>Pre:</b>
     * operario != null
     * <b>Post:</b> Se agrega el operario al sistema.
     */
    public void agregarOperario(Operario operario) throws OperarioExistenteException {
        assert operario != null : "El operario no puede ser nulo";

        if (operarios.contains(operario)) {
            throw new OperarioExistenteException(operario);
        }

        operarios.add(operario);

        assert operarios.contains(operario) : "El operario no se creó";
        assert verificarInvariantes() : "Los invariantes no se cumplen";
    }

    public ModoOperacion getModoOperacion() {
        return modoOperacion;
    }

    private boolean verificarInvariantes() {
        Dia diaActual = Dia.getDiaActual();
        Set<Map.Entry<Producto, List<Promocion>>> entries = promociones.entrySet();
        Iterator<Map.Entry<Producto, List<Promocion>>> iterator = entries.iterator();
        int productosPromocionadosHoy = 0;
        while (iterator.hasNext() && productosPromocionadosHoy < 2) {
            Map.Entry<Producto, List<Promocion>> entry = iterator.next();
            List<Promocion> promociones = entry.getValue();
            Iterator<Promocion> iteratorPromociones = promociones.iterator();
            boolean productoPromocionadoHoy = false;
            while (iteratorPromociones.hasNext() && productosPromocionadosHoy < 2 && !productoPromocionadoHoy) {
                Promocion promocion = iteratorPromociones.next();
                if (promocion.getDiasPromo().contains(diaActual)) {
                    productosPromocionadosHoy++;
                    productoPromocionadoHoy = true;
                }
            }
        }

        // TODO: Verificar si nos cortan la cabeza por usar break.
        /*for (Map.Entry<Producto, List<Promocion>> entry : promociones.entrySet()) {
            List<Promocion> promocionesProducto = entry.getValue();

            for (Promocion promocion : promocionesProducto) {
                if (promocion.getDiasPromo().contains(diaActual)) {
                    productosPromocionadosHoy++;
                    break;
                }
            }

            if (productosPromocionadosHoy >= 2) {
                break;
            }
        }*/

        return nombreLocal != null && !nombreLocal.equals("") && mozos != null
                && mesas != null && productos != null && operarios != null
                && asignacionMesas != null && comandas != null
                && promociones != null && mozos.size() <= 6
                && productosPromocionadosHoy >= 2
                && promociones.values().stream().allMatch(promocionesProducto -> promocionesProducto != null && promocionesProducto.stream().allMatch(promocion -> promocion.getDiasPromo() != null));

    }


    /**
     * Asigna el modo de operacion del sistema.
     * <b>Pre:</b> modoOperacion != null
     * <b>Post: </b> Se asigna el modo de operacion del sistema.
     *
     * @param modoOperacion El modo de operacion del sistema.
     */
    public void setModoOperacion(ModoOperacion modoOperacion) {
        assert modoOperacion != null : "El modo de operacion no puede ser nulo";

        this.modoOperacion = modoOperacion;

        assert this.modoOperacion == modoOperacion : "El modo de operacion no se establecio";
    }

    public Iterator<Operario> getOperarios() {
        return operarios.iterator();
    }
}
