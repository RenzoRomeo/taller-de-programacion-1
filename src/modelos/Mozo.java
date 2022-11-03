package modelos;

import modelos.enums.Estado;

import java.util.Date;

/**
 * <b>Inv:</b>
 * nombre != null
 * apellido != null
 * fechaNacimiento != null
 * hijosACargo >= 0
 * estado != null
 * */
public class Mozo {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int hijosACargo;
    private Estado estado;

    /**
     * Crea un mozo con los datos indicados.
     * <b>Pre:</b>
     * nombre != null
     * apellido != null
     * fechaNacimiento != null
     * hijosACargo >= 0
     * <b>Post:</b> Se crea el mozo con los datos indicados y con estado ACTIVO.
     * */
    public Mozo(String nombre, String apellido, Date fechaNacimiento, int hijosACargo) {
        assert nombre != null : "El nombre no puede ser nulo";
        assert apellido != null : "El apellido no puede ser nulo";
        assert fechaNacimiento != null : "La fecha de nacimiento no puede ser nula";
        assert hijosACargo >= 0 : "La cantidad de hijos a cargo no puede ser negativa";

        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.hijosACargo = hijosACargo;
        this.estado = Estado.ACTIVO;

        assert this.nombre == nombre : "El nombre no se ha asignado correctamente";
        assert this.apellido == apellido : "El apellido no se ha asignado correctamente";
        assert this.fechaNacimiento == fechaNacimiento : "La fecha de nacimiento no se ha asignado correctamente";
        assert this.hijosACargo == hijosACargo : "La cantidad de hijos a cargo no se ha asignado correctamente";
        assert this.estado == Estado.ACTIVO : "El estado no se ha asignado correctamente";
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
