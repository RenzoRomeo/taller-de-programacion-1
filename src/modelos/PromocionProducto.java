package modelos;

public class PromocionProducto extends Promocion {
    private Producto producto;
    private boolean aplicaDosPorUno;
    private boolean aplicaDtoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double dtoPorCantidad_PrecioUnitario;
}
