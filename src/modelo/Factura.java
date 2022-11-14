package modelo;

import enums.FormaDePago;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements Serializable {
    private Date fecha;
    private Mesa mesa;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private double total;
    private FormaDePago formaDePago;
    private ArrayList<Promocion> promocionesAplicadas = new ArrayList<>();
    private Mozo mozo;

    /**
     * Constructor de la clase Factura
     * @param mesa mesa a la que se le genera la factura
     * @param total precio total de la factura
     * @param formaDePago forma de pago de la factura
     * @param promocionesAplicadas promociones aplicadas a la factura
     * @param mozo mozo que atendio la mesa
     *
     * <br>
     * <b>Pre:</b> <br>
     * mesa != null <br>
     * mozo != null <br>
     *
     */
    public Factura(Mesa mesa, FormaDePago formaDePago, double total, ArrayList<Promocion> promocionesAplicadas, Mozo mozo) {
        assert mesa != null : "mesa no puede ser null";
        assert mozo != null : "mozo no puede ser null";

        this.fecha = new Date();
        this.mesa = mesa;
        this.formaDePago = formaDePago;
        this.total = total;
        this.promocionesAplicadas = promocionesAplicadas;
        this.mozo = mozo;
    }


}
