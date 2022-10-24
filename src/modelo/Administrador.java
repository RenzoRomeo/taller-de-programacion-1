package modelo;

public class Administrador extends Operario {
    private boolean establecioContrasena;

    public Administrador(String nombre, String apellido, String nombreUsuario, String contrasenia, boolean activo, boolean establecioContrasena) {
        super(nombre, apellido, nombreUsuario, contrasenia);
        this.establecioContrasena = establecioContrasena;
    }

    public void agregarOperario(Operario operario) {
        Sistema s = Sistema.getInstance();
        s.agregarOperario(operario);
    }
    public void eliminarOperario(Operario operario) {
        Sistema s = Sistema.getInstance();
        s.eliminarOperario(operario);
    }
    public void modificarOperario(Operario operario) {
        Sistema s = Sistema.getInstance();
        s.modificarOperario(operario);
    }

    public void agregarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.agregarMozo(mozo);
    }
    public void eliminarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.eliminarMozo(mozo);
    }
    public void modificarMozo(Mozo mozo) {
        Sistema s = Sistema.getInstance();
        s.modificarMozo(mozo);
    }

    public void agregarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.agregarProducto(producto);
    }
    public void eliminarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.eliminarProducto(producto);
    }
    public void modificarProducto(Producto producto) {
        Sistema s = Sistema.getInstance();
        s.modificarProducto(producto);
    }

    public void agregarMesa(Mesa mesa) {
        Sistema s = Sistema.getInstance();
        s.agregarMesa(mesa);
    }
    public void eliminarMesa(Mesa mesa) {
        Sistema s = Sistema.getInstance();
        s.eliminarMesa(mesa);
    }
    public void modificarMesa(Mesa mesa) {
        Sistema s = Sistema.getInstance();
        s.modificarMesa(mesa);
    }

}
