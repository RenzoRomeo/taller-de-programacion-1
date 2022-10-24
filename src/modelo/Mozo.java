package modelo;

import enums.Estado;

import java.util.Date;

public class Mozo {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int hijosACargo;
    private Estado estado;

    public Mozo(String nombre, String apellido, Date fechaNacimiento, int hijosACargo)
        {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fechaNacimiento = fechaNacimiento;
            this.hijosACargo = hijosACargo;
            this.estado = Estado.ACTIVO;
        }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

