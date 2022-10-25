package modelos;

/**
 * nroMesa >= 0
 * capacidad > 0
 * Si el númro de mesa es 0, la mesa.
 * Si nroMesa == 0, capacidad  0
 * */
public class Mesa {
    private int nroMesa;
    private int capacidad;
    private boolean estaOcupada;

    /**
     * Crea una mesa con los datos indicados.
     * @param nroMesa Número de mesa.
     * @param capacidad Capacidad de la mesa.
     *      Si nroMesa == 0, capacidad  >= 1
     *      Si nroMesa >= 1 0, capacidad  >= 2
     * <b>Pre:</b>
     * nroMesa >= 0
     * capacidad > 0
     * <b>Post:</b> Se crea la mesa con los datos indicados.
     * */
    public Mesa(int nroMesa, int capacidad) {
        assert nroMesa >= 0 : "El número de mesa no puede ser negativo";
        assert capacidad > 0 : "La capacidad no puede ser negativa";

        assert nroMesa == 0 || capacidad >= 2 : "La capacidad de una mesa no puede ser menor a 2";

        this.nroMesa = nroMesa;
        this.capacidad = capacidad;
        this.estaOcupada = false;

        assert this.nroMesa == nroMesa : "El número de mesa no se ha asignado correctamente";
        assert this.capacidad == capacidad : "La capacidad no se ha asignado correctamente";
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }
}