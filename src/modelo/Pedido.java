package modelo;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
    private Producto producto;
    private int cantidad;
    private Date fechaActual;

    /**
     *
     * @param producto
     * @param cantidad
     *
     * <br>
     * <b>Pre:</b> <br>
     * producto != null <br>
     * cantidad > 0 <br>
     * cantidad < stock <br>
     *
     * <b>Post:</b> <br>
     * Se crea un pedido con los datos ingresados <br>
     */
    public Pedido(Producto producto, int cantidad) {
        assert producto != null;
        assert cantidad > 0;
        assert cantidad < producto.getStock();

        producto.setStock(producto.getStock() - cantidad);
        this.producto = producto;
        this.cantidad = cantidad;
        this.fechaActual = new Date();


        assert this.producto.equals(producto);
        assert this.cantidad == cantidad;
        assert this.fechaActual != null;
    }

    public Producto getProducto() {
        return this.producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
}
