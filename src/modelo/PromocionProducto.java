package modelo;

import enums.Dia;

import java.util.ArrayList;

public class PromocionProducto extends Promocion{
    private Producto producto;
    private boolean aplicaDosPorUno;
    private boolean aplicaDescuentoPorCantidad;
    private int dtoPorCantidad_CantMinima;
    private double descuentoPorCantidad_PrecioUnitario;


    /**
     * Constructor de la clase PromocionProducto
     * @param id
     * @param activa
     * @param diasPromo
     * @param producto
     * @param aplicaDosPorUno
     * @param aplicaDescuentoPorCantidad
     * @param dtoPorCantidad_CantMinima
     * @param descuentoPorCantidad_PrecioUnitario
     *
     * <br>
     * <b>Pre:</b> <br>
     * id > 0 <br>
     * diasPromo != null <br>
     * producto != null <br>
     * dtoPorCantidad_CantMinima >= 0 <br>
     * descuentoPorCantidad_PrecioUnitario >= 0 <br>
     * aplicarDosPorUno == true || aplicarDescuentoPorCantidad == true <br>
     * descuentoPorCantidad_PrecioUnitario >= 0 <br>
     *
     * <b>Post:</b> <br>
     * Se crea una promocion de producto con los datos ingresados <br>
     */
    public PromocionProducto(int id, boolean activa, ArrayList<Dia> diasPromo, Producto producto, boolean aplicaDosPorUno, boolean aplicaDescuentoPorCantidad, int dtoPorCantidad_CantMinima, double descuentoPorCantidad_PrecioUnitario) {
        super(id, activa, diasPromo);

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
