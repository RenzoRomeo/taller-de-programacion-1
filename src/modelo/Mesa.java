package modelo;

public class Mesa {
    private int nroMesa;
    private int capacidad;
    private boolean estaOcupada;

    public Mesa (int nroMesa, int capacidad)
        {
            this.nroMesa = nroMesa;
            this.capacidad = capacidad;
            this.estaOcupada = false;
        }
}
