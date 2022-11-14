package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    /**
     * Constructor de la clase Producto
     * @param id id del producto
     * @param nombre nombre del producto
     * @param precioCosto precio de costo del producto
     * @param precioVenta precio de venta del producto
     * @param stockInicial stock inicial del producto
     *
     * <br>
     * <b>Pre:</b> <br>
     * id mayor a 0 <br>
     * nombre != null <br>
     * precioCosto mayor a 0 <br>
     * precioVenta mayor a 0 <br>
     * precioVenta mayor a precioCosto <br>
     * stockInicial mayor o igual a 0 <br>
     *
     * <b>Post:</b> <br>
     * Se crea un producto con los datos ingresados <br>
     */
    public Producto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial) {
        assert id > 0 : "El id debe ser mayor a 0";
        assert nombre != null : "El nombre no puede ser nulo";
        assert precioCosto > 0 : "El precio de costo debe ser mayor a 0";
        assert precioVenta > 0 : "El precio de venta debe ser mayor a 0";
        assert precioVenta > precioCosto : "El precio de venta debe ser mayor al precio de costo";
        assert stockInicial >= 0 : "El stock inicial debe ser mayor o igual a 0";

        this.id = id;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stockInicial;

        assert this.id == id : "El id no es el mismo";
        assert this.nombre.equals(nombre) : "El nombre no es el mismo";
        assert this.precioCosto == precioCosto : "El precio de costo no es el mismo";
        assert this.precioVenta == precioVenta : "El precio de venta no es el mismo";
        assert this.stock == stockInicial : "El stock no es el mismo";
    }

    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecioVenta() {
        return this.precioVenta;
    }

}
