package modelo;

public class Mesa {
    private int nroMesa;
    private int capacidad;
    private boolean estaOcupada;

    /**
     *
     * @param nroMesa
     * @param capacidad
     *
     * <b>Pre:</b>
     * nroMesa inexistente
     * nroMesa >= 0
     * capacidad >= 2
     *
     * <b>Post:</b>
     * Se crea una mesa con los datos ingresados
     */
    public Mesa (int nroMesa, int capacidad)
        {
            assert !Sistema.getInstance().existeMesa(nroMesa);
            assert nroMesa >= 0;
            assert capacidad >= 2;

            this.nroMesa = nroMesa;
            this.capacidad = capacidad;
            this.estaOcupada = false;

            assert this.nroMesa == nroMesa;
            assert this.capacidad == capacidad;
            assert this.estaOcupada == false;
        }

    public int getNroMesa() {
        return this.nroMesa;
    }
}
