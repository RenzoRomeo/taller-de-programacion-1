package modelo;

import enums.Dia;

import java.io.Serializable;
import java.util.ArrayList;

public class PromocionProducto extends Promocion implements Serializable {
    private Producto producto;
    private boolean aplicaDosPorUno;
    private boolean aplicaDescuentoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double descuentoPorCantidad_PrecioUnitario;


    /**
     * Constructor de la clase PromocionProducto
     * @param id id de la promocion
     * @param diasPromo dias en los que se aplica la promocion
     * @param producto producto al que se aplica la promocion
     * @param aplicaDosPorUno si la promocion es de dos por uno
     * @param aplicaDescuentoPorCantidad si la promocion es de descuento por cantidad
     * @param dtoPorCantidad_CantMinima cantidad minima para aplicar el descuento
     * @param descuentoPorCantidad_PrecioUnitario precio unitario con el descuento aplicado
     *
     * <br>
     * <b>Pre:</b> <br>
     * producto != null <br>
     * dtoPorCantidad_CantMinima mayor o igual a 0 <br>
     * descuentoPorCantidad_PrecioUnitario mayor o igual a 0 <br>
     * aplicarDosPorUno == true || aplicarDescuentoPorCantidad == true <br>
     * descuentoPorCantidad_PrecioUnitario mayor o igual a 0 <br>
     *
     * <b>Post:</b> <br>
     * Se crea una promocion de producto con los datos ingresados <br>
     */
    public PromocionProducto(int id, ArrayList<Dia> diasPromo, Producto producto, boolean aplicaDosPorUno, boolean aplicaDescuentoPorCantidad, int dtoPorCantidad_CantMinima, double descuentoPorCantidad_PrecioUnitario) {
        super(id, diasPromo);

        assert producto != null;
        assert dtoPorCantidad_CantMinima >= 0;
        assert descuentoPorCantidad_PrecioUnitario >= 0;
        assert aplicaDosPorUno == true || aplicaDescuentoPorCantidad == true;
        assert descuentoPorCantidad_PrecioUnitario >= 0;


        this.producto = producto;
        this.aplicaDosPorUno = aplicaDosPorUno;
        this.aplicaDescuentoPorCantidad = aplicaDescuentoPorCantidad;
        this.dtoPorCantidad_CantMinima = dtoPorCantidad_CantMinima;
        this.descuentoPorCantidad_PrecioUnitario = descuentoPorCantidad_PrecioUnitario;

        assert this.producto.equals(producto);
        assert this.aplicaDosPorUno == aplicaDosPorUno;
        assert this.aplicaDescuentoPorCantidad == aplicaDescuentoPorCantidad;
        assert this.dtoPorCantidad_CantMinima == dtoPorCantidad_CantMinima;
        assert this.descuentoPorCantidad_PrecioUnitario == descuentoPorCantidad_PrecioUnitario;
    }

    public Producto getProducto() {
        return producto;
    }


    /**
     * Metodo que aplica promocion a un pedido
     * @param pedido pedido al que se le aplica la promocion
     * @param subtotal subtotal del pedido
     *
     * <br>
     * <b>Pre:</b> <br>
     * pedido != null <br>
     * subtotal mayor 0 <br>
     *
     * @return subtotal con descuento aplicado
     */
    public double realizaDescuento(Pedido pedido, double subtotal){
        double descuento = 0.0;
        if (aplicaDosPorUno){
            descuento += subtotal / 2;
        }
        if (aplicaDescuentoPorCantidad && pedido.getCantidad() >= dtoPorCantidad_CantMinima){
            descuento += subtotal - (descuentoPorCantidad_PrecioUnitario * pedido.getCantidad());
        }
        return subtotal - descuento;
    }
}
