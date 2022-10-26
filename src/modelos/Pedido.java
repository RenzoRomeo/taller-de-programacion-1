package modelos;

import java.util.Date;

/**
 * Clase que representa un pedido dentro de una comanda.
 * <b>Inv:</b>
 * producto != null
 * cantidad > 0
 */
public class Pedido {
    private Producto producto;
    private int cantidad;
    private Date fecha;

    /**
     * Crea un pedido con un producto y su cantidad.
     * @param producto Producto del pedido.
     * @param cantidad Cantidad de unidades del producto pedidas.
     * <b>Pre:</b>
     * producto != null
     * cantidad > 0
     * <b>Post:</b>
     * Se crea un nuevo pedido con el producto y la cantidad ingresados.
     * La fecha del pedido es la actual.
     */
    public Pedido(Producto producto, int cantidad) {
        assert producto != null : "El producto no puede ser nulo";
        assert cantidad > 0 : "La cantidad debe ser mayor a 0";

        this.producto = producto;
        this.cantidad = cantidad;
        fecha = new Date();

        assert this.producto == producto : "El producto no se asignó correctamente";
        assert this.cantidad == cantidad : "La cantidad no se asignó correctamente";
        // TODO validar la fecha.
    }
}
