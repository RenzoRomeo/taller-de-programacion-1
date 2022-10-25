package modelo;

import enums.Estado;

import java.time.LocalDate;
import java.util.Date;

public class Mozo {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int hijosACargo;
    private Estado estado;

    /**
     *
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param hijosACargo
     *
     * <b>Pre:</b>
     * nombre != null
     * apellido != null
     * fechaNacimiento != null
     * hijosACargo >= 0
     *
     * <b>Post:</b>
     * Se crea un mozo con los datos ingresados
     */
    public Mozo(String nombre, String apellido, Date fechaNacimiento, int hijosACargo)
        {
            assert nombre != null;
            assert apellido != null;
            assert fechaNacimiento != null;
            assert LocalDate.now().getYear() - fechaNacimiento.getYear() >= 18;
            assert hijosACargo >= 0;

            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = fechaNacimiento;
            this.hijosACargo = hijosACargo;
            this.estado = Estado.ACTIVO;

            assert this.nombre.equals(nombre);
            assert this.apellido.equals(apellido);
            assert this.fechaNacimiento.equals(fechaNacimiento);
            assert this.hijosACargo == hijosACargo;
            assert this.estado == Estado.ACTIVO;
        }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Estado getEstado() {
        return this.estado;
    }
}

