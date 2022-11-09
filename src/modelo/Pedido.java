package modelo;

import java.util.Date;

public class Pedido {
    private Producto producto;
    private int cantidad;
    private Date fechaActual;

    /**
     *
     * @param producto
     * @param cantidad
     *
     * <b>Pre:</b>
     * producto != null
     * cantidad > 0
     * cantidad < stock
     *
     * <b>Post:</b>
     * Se crea un pedido con los datos ingresados
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
