package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    /**
     * Constructor de la clase Producto
     * @param id
     * @param nombre
     * @param precioCosto
     * @param precioVenta
     * @param stockInicial
     *
     * <br>
     * <b>Pre:</b> <br>
     * id > 0 <br>
     * nombre != null <br>
     * precioCosto > 0 <br>
     * precioVenta > 0 <br>
     * precioVenta > precioCosto <br>
     * stockInicial >= 0 <br>
     *
     * <b>Post:</b> <br>
     * Se crea un producto con los datos ingresados <br>
     */
    public Producto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial) {
        assert id > 0;
        assert nombre != null;
        assert precioCosto > 0;
        assert precioVenta > 0;
        assert precioVenta > precioCosto;
        assert stockInicial >= 0;

        this.id = id;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.stock = stockInicial;

        assert this.id == id;
        assert this.nombre.equals(nombre);
        assert this.precioCosto == precioCosto;
        assert this.precioVenta == precioVenta;
        assert this.stock == stockInicial;
    }

    public int getStock() {
        return this.stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecioVenta() {
        return this.precioVenta;
    }

}
