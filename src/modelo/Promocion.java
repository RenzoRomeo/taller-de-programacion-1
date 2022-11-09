package modelo;

import enums.Dia;

import java.util.ArrayList;

public abstract class Promocion {
    private int id;
    private boolean activa;
    private ArrayList<Dia> diasPromo = new ArrayList<>();

    public Promocion(int id, boolean activa, ArrayList<Dia> diasPromo) {
        this.id = id;
        this.activa = true;
    }
    public boolean estaActiva() {
        return activa;
    }

    public ArrayList<Dia> getDiasPromo() {
        return diasPromo;
    }

}
