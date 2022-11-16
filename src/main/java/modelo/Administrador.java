package modelo;

import excepciones.*;

import java.io.Serializable;
import java.util.Date;

//implementa interfaz para persistir binario
public class Administrador extends Operario implements Serializable {
    private boolean establecioContrasena;

    /**
     * Constructor de la clase Administrador con los valores por defecto
     * <b>Post:</b>
     * establecioContrasena == false <br>
     */

    public Administrador(){
        super("ADMIN", "ADMIN", "ADMIN", "Admin1234");
        establecioContrasena = false;

        assert establecioContrasena == false;
    }


    /**
     * Metodo que crea nuevo operario y lo carga al sistema
     * @param nombre nombre del operario
     * @param apellido apellido del operario
     * @param nombreDeUsuario nombre de usuario del operario
     * @param contrasena contrasena del operario
     *
     * Este metodo se utiliza para crear un nuevo operario
     *
     *
     */
    public void agregarOperario(String nombre, String apellido, String nombreDeUsuario, String contrasena) {
        Operario o = new Operario(nombre, apellido, nombreDeUsuario, contrasena);
        Sistema s = Sistema.getInstance();
        try {
            s.agregarOperario(o);
        } catch (NombreDeUsuarioNoDisponibleException e) {
            e.printStackTrace();
        }

    }

    /**
     * Este metodo se utiliza para eliminar un operario del sistema
     *
     * @param operario operario a eliminar
     */
    public void eliminarOperario(Operario operario) throws UsuarioNoExisteException {
        Sistema s = Sistema.getInstance();
        s.eliminarOperario(operario);
    }

    /**
     * Este metodo se utiliza para crear un nuevo mozo
     *
     * @param nombre          nombre del mozo
     * @param apellido        apellido del mozo
     * @param fechaNacimiento fecha de nacimiento del mozo
     * @param hijosACargo     hijos a cargo del mozo
     */
    public void agregarMozo(String nombre, String apellido, Date fechaNacimiento, int hijosACargo) throws MozoYaExistenteException {
        Mozo mozo = new Mozo(nombre, apellido, fechaNacimiento, hijosACargo);
        Sistema s = Sistema.getInstance();
        s.agregarMozo(mozo);
    }

    /**
     * Este metodo se utiliza para eliminar un mozo del sistema
     *
     * @param mozo mozo a eliminar
     */

    public void eliminarMozo(Mozo mozo) throws MozoNoExisteException {
        Sistema s = Sistema.getInstance();
        s.eliminarMozo(mozo);
    }

    /**
     * Este metodo se utiliza para crear un nuevo producto
     *
     * @param id           id del producto
     * @param nombre       nombre del producto
     * @param precioCosto  precio de costo del producto
     * @param precioVenta  precio de venta del producto
     * @param stockInicial stock inicial del producto
     */
    public void agregarProducto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial) throws ProductoYaExistenteException {
        Producto producto = new Producto(id, nombre, precioCosto, precioVenta, stockInicial);
        Sistema s = Sistema.getInstance();
        s.agregarProducto(producto);
    }

    /**
     * Este metodo se utiliza para eliminar un producto del sistema
     *
     * @param producto producto a eliminar
     */
    public void eliminarProducto(Producto producto) throws ProductoNoExisteException {
        Sistema s = Sistema.getInstance();
        s.eliminarProducto(producto);
    }

    /**
     * Este metodo se utiliza para crear una nueva mesa
     *
     * @param nroMesa   numero de mesa
     * @param capacidad capacidad de la mesa
     */
    public void agregarMesa(int nroMesa, int capacidad) throws MesaYaExistenteException {
        Mesa mesa = new Mesa(nroMesa, capacidad);
        Sistema s = Sistema.getInstance();
        s.agregarMesa(mesa);
    }

    /**
     * Este metodo se utiliza para eliminar una mesa del sistema
     *
     * @param mesa mesa a eliminar
     */
    public void eliminarMesa(Mesa mesa) throws MesaNoExisteException {
        Sistema s = Sistema.getInstance();
        s.eliminarMesa(mesa);
    }

    public boolean esEstablecioContrasena() {
        return establecioContrasena;
    }
     public void setEstablecioContrasena() {
         this.establecioContrasena = true;
     }

}
