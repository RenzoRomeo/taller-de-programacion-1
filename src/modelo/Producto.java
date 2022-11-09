package modelo;

public class Producto {
    private int id;
    private String nombre;
    private double precioCosto;
    private double precioVenta;
    private int stock;

    /**
     *
     * @param id
     * @param nombre
     * @param precioCosto
     * @param precioVenta
     * @param stockInicial
     *
     * <b>Pre:</b>
     * id > 0
     * nombre != null
     * precioCosto > 0
     * precioVenta > 0
     * precioVenta > precioCosto
     * stockInicial >= 0
     *
     * <b>Post:</b>
     * Se crea un producto con los datos ingresados
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
