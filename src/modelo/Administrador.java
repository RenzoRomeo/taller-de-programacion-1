package modelo;

import excepciones.AdminExistenteException;
import excepciones.NombreDeUsuarioNoDisponibleException;

public class Administrador extends Operario {
    private boolean establecioContrasena = false;

    public Administrador(){
        super("ADMIN", "ADMIN", "ADMIN", "ADMIN1234");
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
     * <b>Pre: </b>
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
    public void eliminarOperario(Operario operario) {
        Sistema s = Sistema.getInstance();
        s.eliminarOperario(operario);
    }

    public void agregarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.agregarMozo(mozo);
    }
    public void eliminarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.eliminarMozo(mozo);
    }


    public void agregarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.agregarProducto(producto);
    }
    public void eliminarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.eliminarProducto(producto);
    }

    public void agregarMesa(Mesa mesa) {
        Sistema s = Sistema.getInstance();
        s.agregarMesa(mesa);
    }
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
