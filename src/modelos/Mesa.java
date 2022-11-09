package modelos;

/**
 * <b>Inv:</b> <br>
 * nroMesa >= 0 <br>
 * capacidad > 0 <br>
 * Si nroMesa == 0, capacidad  >= 1 <br>
 * Si nroMesa >= 1 0, capacidad  >= 2 <br>
 */
public class Mesa {
    private int nroMesa;
    private int capacidad;
    private boolean estaOcupada;

    /**
     * Crea una mesa con los datos indicados. <br>
     * <b>Pre:</b> <br>
     * Si nroMesa == 0, capacidad  >= 1 <br>
     * Si nroMesa >= 1 0, capacidad  >= 2 <br>
     * nroMesa >= 0 <br>
     * capacidad > 0 <br>
     * <b>Post:</b> <br>
     * Se crea la mesa con los datos indicados. <br>
     * @param nroMesa Número de mesa.
     * @param capacidad Capacidad de la mesa.
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

    // TODO: verificar invariantes mesa
}