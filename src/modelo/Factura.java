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

    /**
     * Constructor de la clase Factura
     * @param mesa
     * @param mozo
     *
     * <b>Pre:</b>
     * mesa != null
     * mozo != null
     *
     */
    public Factura(Mesa mesa, FormaDePago formaDePago, double total, ArrayList<Promocion> promocionesAplicadas, Mozo mozo) {
        assert mesa != null;
        assert mozo != null;

        this.fecha = new Date();
        this.mesa = mesa;
        this.formaDePago = formaDePago;
        this.total = total;
        this.promocionesAplicadas = promocionesAplicadas;
        this.mozo = mozo;
    }


}
