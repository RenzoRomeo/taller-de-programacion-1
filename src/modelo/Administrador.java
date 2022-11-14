package modelo;

import excepciones.AdminExistenteException;
import excepciones.NombreDeUsuarioNoDisponibleException;

import java.util.Date;

public class Administrador extends Operario {
    private boolean establecioContrasena;

    /**
     * Constructor de la clase Administrador con los valores por defecto
     * <b>Post:</b>
     * establecioContrasena == false <br>
     */

    public Administrador(){
        super("ADMIN", "ADMIN", "ADMIN", "ADMIN1234");
        establecioContrasena = false;

        assert establecioContrasena == false;
    }


    /**
     *
     * @param nombre
     * @param apellido
     * @param nombreDeUsuario
     * @param contrasena
     * @throws NombreDeUsuarioNoDisponibleException
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
     * @param operario
     */
    public void eliminarOperario(Operario operario) {
        Sistema s = Sistema.getInstance();
        s.eliminarOperario(operario);
    }

    /**
     * Este metodo se utiliza para crear un nuevo mozo
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param hijosACargo
     */
    public void agregarMozo(String nombre, String apellido, Date fechaNacimiento, int hijosACargo) {
        Mozo mozo = new Mozo(nombre, apellido, fechaNacimiento, hijosACargo);
        Sistema s = Sistema.getInstance();
        s.agregarMozo(mozo);
    }

    /**
     * Este metodo se utiliza para eliminar un mozo del sistema
     * @param mozo
     *
     */
    public void eliminarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.eliminarMozo(mozo);
    }

    /**
     * Este metodo se utiliza para crear un nuevo producto
     * @param id
     * @param nombre
     * @param precioCosto
     * @param precioVenta
     * @param stockInicial
     */
    public void agregarProducto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial) {
        Producto producto = new Producto(id, nombre, precioCosto, precioVenta, stockInicial);
        Sistema s = Sistema.getInstance();
        s.agregarProducto(producto);
    }

    /**
     * Este metodo se utiliza para eliminar un producto del sistema
     * @param producto
     */
    public void eliminarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.eliminarProducto(producto);
    }

    /**
     * Este metodo se utiliza para crear una nueva mesa
     * @param nroMesa
     * @param capacidad
     *
     */
    public void agregarMesa(int nroMesa, int capacidad) {
        Mesa mesa = new Mesa(nroMesa, capacidad);
        Sistema s = Sistema.getInstance();
        s.agregarMesa(mesa);
    }

    /**
     * Este metodo se utiliza para eliminar una mesa del sistema
     * @param mesa
     */
    public void eliminarMesa(Mesa mesa) {
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
