package modelo;

import enums.FormaDePago;

public class PromocionTemporal {
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
    public PromocionTemporal(String nombre, FormaDePago formaDePago, int porcentajeDescuento, boolean esAcumulable) {
        assert nombre != null;
        assert formaDePago != null;
        assert porcentajeDescuento > 0;
        assert porcentajeDescuento <= 100;

        this.nombre = nombre;
        this.formaDePago = formaDePago;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esAcumulable = esAcumulable;
    }
}
