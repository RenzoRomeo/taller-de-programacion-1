package modelos;

import modelos.enums.FormaPago;

public class PromocionTemporal extends Promocion {
    private String nombre;
    private FormaPago formaPago;
    private int porcentajeDescuento;
    private boolean esAcumulable;
}
