package modelo;

import enums.Dia;
import enums.FormaDePago;

import java.util.ArrayList;

public class PromocionTemporal extends Promocion{
    private String nombre;
    private FormaDePago formaDePago;
    private int porcentajeDescuento;
    private boolean esAcumulable;

    /**
     *
     * @param nombre
     * @param formaDePago
     * @param porcentajeDescuento
     * @param esAcumulable
     *
     * <b>Pre:</b>
     * nombre != null
     * formaDePago != null
     * porcentajeDescuento > 0
     * porcentajeDescuento <= 100
     *
     */
    public PromocionTemporal(int id, boolean activa, ArrayList<Dia> diasPromo, String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable) {
        super(id, activa, diasPromo);

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

    public double realizaDescuento(double precio) {
        return precio - (precio * porcentajeDescuento / 100);
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }
}
