package modelo;

public class PromocionProducto extends Promocion{
    private Producto producto;
    private boolean aplicaDosPorUno;
    private boolean aplicaDescuentoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double descuentoPorCantidad_PrecioUnitario;
}
