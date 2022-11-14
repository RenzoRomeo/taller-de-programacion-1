package modelo;

import java.io.Serializable;

public class Mesa implements Serializable {
    private int nroMesa;
    private int capacidad;
    private boolean estaOcupada;

    /**
     *
     * @param nroMesa numero de mesa
     * @param capacidad capacidad de la mesa
     *
     * <br>
     * <b>Pre:</b> <br>
     * nroMesa inexistente <br>
     * nroMesa mayor o igual a 0 <br>
     * capacidad mayor o igual a 2 <br>
     *
     * <b>Post:</b> <br>
     * Se crea una mesa con los datos ingresados <br>
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
    public boolean getEstaOcupada() {
        return this.estaOcupada;
    }
    public void setEstaOcupada(boolean estaOcupada) {
        this.estaOcupada = estaOcupada;
    }
}
