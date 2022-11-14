package modelo;

import enums.Dia;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Promocion implements Serializable {
    private int id;
    private boolean activa;
    private ArrayList<Dia> diasPromo = new ArrayList<>();

    /**
     * Constructor de la clase Promocion
     * @param id
     * @param diasPromo
     *
     * <br>
     * <b>Pre:</b> <br>
     * id > 0 <br>
     * diasPromo != null <br>
     */
    public Promocion(int id, ArrayList<Dia> diasPromo) {
        assert id > 0 : "id no puede ser menor o igual a 0";
        assert diasPromo != null : "diasPromo no puede ser null";

        this.id = id;
        this.diasPromo = diasPromo;
        this.activa = true;
    }
    public boolean estaActiva() {
        return activa;
    }

    public ArrayList<Dia> getDiasPromo() {
        return diasPromo;
    }

}
