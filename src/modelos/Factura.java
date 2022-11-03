package modelos;

import modelos.enums.FormaPago;

import java.util.Date;
import java.util.List;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private List<Pedido> pedido;
    private double total;
    private FormaPago formaPago;
    private List<Promocion> promocionesAplicadas;
    private Mozo mozo;
}
