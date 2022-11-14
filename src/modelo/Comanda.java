package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Comanda {
    private Date fecha;
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Comanda() {
        this.fecha = new Date();
    }

    public void agregarPedido(Producto producto, int cantidad) {
        Pedido pedido = new Pedido(producto, cantidad);
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
