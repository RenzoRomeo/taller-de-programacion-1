package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Comanda implements Serializable {
    private Date fecha;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    /**
     * Constructor de la clase Comanda
     *
     */
    public Comanda() {
        this.fecha = new Date();
    }

    /**
     * Agrega un pedido a la comanda
     * @param producto producto del pedido
     * @param cantidad cantidad del producto
     */
    public void agregarPedido(Producto producto, int cantidad) {
        Pedido pedido = new Pedido(producto, cantidad);
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
