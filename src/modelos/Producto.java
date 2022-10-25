package modelos;

/**
 * Clase que representa a un producto del sistema.
 * <b>Inv:</b>
 * nombre != null
 * nombre != ""
 * el nombre permanece constante
 * precioCosto >= 0
 * precioVenta >= 0
 * precioVenta > precioCosto
 * stock >= 0
 */
public class Producto {
    private int id;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    private static int ultimoId = 0;

    /**
     * Constructor de la clase Producto.
     * @param nombre Nombre del producto.
     * @param precioCosto Precio de costo del producto.
     * @param precioVenta Precio de venta del producto.
     * @param stock Stock del producto.
     * <b>Pre:</b>
     * nombre != null
     * nombre != ""
     * precioCosto >= 0
     * precioVenta >= 0
     * precioVenta > precioCosto
     * stock >= 0
     * <b>Post:</b>
     * Se crea un nuevo producto con los datos ingresados y un id unico autogenerado.
     */
    public Producto(String nombre, double precioCosto, double precioVenta, int stock) {
        assert nombre != null : "El nombre del producto no puede ser nulo.";
        assert nombre != "" : "El nombre del producto no puede ser vacio.";
        assert precioCosto >= 0 : "El precio de costo del producto no puede ser negativo.";
        assert precioVenta >= 0 : "El precio de venta del producto no puede ser negativo.";
        assert precioVenta > precioCosto : "El precio de venta del producto no puede ser menor o igual al precio de costo.";
        assert stock >= 0 : "El stock del producto no puede ser negativo.";

        this.id = ultimoId;
        ultimoId++;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stock;

        assert this.id == ultimoId - 1 : "El id del producto no es el esperado.";
        assert this.nombre.equals(nombre) : "El nombre del producto no es el esperado.";
        assert this.precioCosto == precioCosto : "El precio de costo del producto no es el esperado.";
        assert this.precioVenta == precioVenta : "El precio de venta del producto no es el esperado.";
        assert this.stock == stock : "El stock del producto no es el esperado.";
    }

    /**
     * Incrementa el stock en una cantidad dada.
     * @param cantidad Cantidad a incrementar.
     * <b>Pre:</b>
     * cantidad > 0
     * <b>Post:</b>
     * Se incrementa el stock en la cantidad dada.
     */
    public void incrementarStock(int cantidad) {
        assert cantidad > 0 : "La cantidad a incrementar debe ser mayor a 0";

        int stockInicial = this.stock;
        this.stock += cantidad;

        assert this.stock == stockInicial + cantidad : "El stock no se incremento correctamente";
    }

    /**
     * Decrementa el stock en una cantidad dada.
     * @param cantidad Cantidad a decrementar.
     * <b>Pre:</b>
     * cantidad > 0
     * <b>Post:</b>
     * Se decrementa el stock en la cantidad dada.
     */
    public void decrementarStock(int cantidad) {
        assert cantidad > 0 : "La cantidad a decrementar debe ser mayor a 0";

        int stockInicial = this.stock;
        this.stock -= cantidad;

        assert this.stock == stockInicial - cantidad : "El stock no se decremento correctamente";
    }

    /**
     * Cambia el precio de venta del producto.
     * @param precioVenta Nuevo precio de venta.
     * <b>Pre:</b>
     * precioVenta > 0
     * precioVenta > precioCosto
     * <b>Post:</b>
     * Se cambia el precio de venta del producto.
     */
    public void cambiarPrecioVenta(double precioVenta) {
        assert precioVenta > 0 : "El precio de venta debe ser mayor a 0";
        assert precioVenta > this.precioCosto : "El precio de venta debe ser mayor al precio de costo";

        this.precioVenta = precioVenta;

        assert this.precioVenta == precioVenta : "El precio de venta no se cambio correctamente";
    }

    public double getPrecioVenta() {
        return this.precioVenta;
    }

    /**
     * Cambia el precio de costo del producto.
     * @param precioCosto Nuevo precio de costo.
     * <b>Pre:</b>
     * precioCosto > 0
     * precioVenta > precioCosto
     * <b>Post:</b>
     * Se cambia el precio de costo del producto.
     */
    public void cambiarPrecioCosto(double precioCosto) {
        assert precioCosto > 0 : "El precio de costo debe ser mayor a 0";
        assert precioCosto < this.precioVenta : "El precio de costo debe ser menor al precio de venta";

        this.precioCosto = precioCosto;

        assert this.precioCosto == precioCosto : "El precio de costo no se cambio correctamente";
    }

    public double getPrecioCosto() {
        return this.precioCosto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
