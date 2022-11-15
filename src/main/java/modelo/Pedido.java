package modelo;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
    private Producto producto;
    private int cantidad;
    private Date fechaActual;

    /**
     *
     * @param producto producto del pedido
     * @param cantidad cantidad del producto
     *
     * <br>
     * <b>Pre:</b> <br>
     * producto != null <br>
     * cantidad mayor a 0 <br>
     * cantidad menor a stock <br>
     *
     * <b>Post:</b> <br>
     * Se crea un pedido con los datos ingresados <br>
     */
    public Pedido(Producto producto, int cantidad) {
        assert producto != null : "El producto no puede ser nulo";
        assert cantidad > 0 : "La cantidad debe ser mayor a 0";
        assert cantidad < producto.getStock() : "La cantidad debe ser menor al stock";

        producto.setStock(producto.getStock() - cantidad);
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaActual = new Date();


        assert this.producto.equals(producto) : "El producto no es el mismo";
        assert this.cantidad == cantidad : "La cantidad no es la misma";
        assert this.fechaActual != null : "La fecha no puede ser nula";
    }

    public Producto getProducto() {
        return this.producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
}
