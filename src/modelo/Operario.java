package modelo;

import enums.Estado;

public class Operario {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasenia;
    private boolean activo;


    /**
     * Constructor de la clase Operario
     * @param nombre
     * @param apellido
     * @param nombreUsuario
     * @param contrasenia
     *
     * <b>Pre:</b>
     * nombre != null
     * apellido != null
     * nombreUsuario != null
     * nombreUsuario != ""
     * nombreUsuario.length() <= 10
     * contrasenia != null
     * contrasenia != ""
     * contrasenia.length() >= 6
     * contrasenia.length() <= 12
     * Contrasenia contiene al menos una mayuscula
     * Contrasenia contiene al menos un numero
     *
     * <b>Post:</b>
     * Se crea un nuevo operario con los datos recibidos.
     *
     */
    public Operario(String nombre, String apellido, String nombreUsuario, String contrasenia) {
        assert nombre != null;
        assert apellido != null;
        assert nombreUsuario != null;
        assert nombreUsuario != "";
        assert nombreUsuario.length() <= 10;
        assert contrasenia != null;
        assert contrasenia != "";
        assert contrasenia.length() >= 6;
        assert contrasenia.length() <= 12;
        assert contrasenia.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,10}$"); //Regex que verifica que la contrasenia tenga al menos una mayuscula, un numero y que no tenga espacios en blanco

        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.activo = true;

        assert this.nombre == nombre;
        assert this.apellido == apellido;
        assert this.nombreUsuario == nombreUsuario;
        assert this.contrasenia == contrasenia;
        assert this.activo == true;

    }

    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        mozo.setEstado(estado);
    }

    public void asignarMesa(Mozo mozo, Mesa mesa) {
        Sistema s = Sistema.getInstance();
        s.asignarMesa(mozo, mesa);
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public boolean isActivo() {
        return this.activo;
    }

}
