package modelo;

import enums.Dia;
import enums.FormaDePago;

import java.io.Serializable;
import java.util.ArrayList;

public class PromocionTemporal extends Promocion implements Serializable {
    private String nombre;
    private FormaDePago formaDePago;
    private int porcentajeDescuento;
    private boolean esAcumulable;

    /**
     * Constructor de la clase PromocionTemporal
     * @param id id de la promocion
     * @param diasPromo dias en los que se aplica la promocion
     * @param nombre nombre de la promocion
     * @param formaDePago forma de pago en la que se aplica la promocion
     * @param porcentajeDescuento porcentaje de descuento que se aplica
     * @param esAcumulable si la promocion es acumulable o no
     *
     * <br>
     * <b>Pre:</b> <br>
     * nombre != null <br>
     * formaDePago != null <br>
     * porcentajeDescuento mayor a 0 <br>
     * porcentajeDescuento menor o igual a 100 <br>
     *
     */
    public PromocionTemporal(int id, ArrayList<Dia> diasPromo, String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable) {
        super(id, diasPromo);

        assert nombre != null;
        assert formaDePago != null;
        assert porcentajeDescuento > 0;
        assert porcentajeDescuento <= 100;

        this.nombre = nombre;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esAcumulable = esAcumulable;
    }

    public boolean esAcumulable() {
        return esAcumulable;
    }

    /**
     * Calcula el descuento de la promocion
     * @param precio precio del producto
     *
     * <br>
     * <b>Pre:</b> <br>
     * precio mayor a 0 <br>
     *
     * @return aplica descuento a precio
     */
    public double realizaDescuento(double precio) {
        return precio - (precio * porcentajeDescuento / 100);
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }
}
