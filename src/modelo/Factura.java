package modelo;

import enums.FormaDePago;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private double total;
    private FormaDePago formaDePago;
    private ArrayList<Promocion> promocionesAplicadas = new ArrayList<>();
    private Mozo mozo;


}
