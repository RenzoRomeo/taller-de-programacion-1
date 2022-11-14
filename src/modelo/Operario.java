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
        assert nombre != null : "El nombre no puede ser nulo";
        assert apellido != null : "El apellido no puede ser nulo";
        assert nombreUsuario != null : "El nombre de usuario no puede ser nulo";
        assert nombreUsuario != "" : "El nombre de usuario no puede ser vacio";
        assert nombreUsuario.length() <= 10 : "El nombre de usuario no puede tener mas de 10 caracteres";
        assert contrasenia != null : "La contrasenia no puede ser nula";
        assert contrasenia != "" : "La contrasenia no puede ser vacia";
        assert contrasenia.length() >= 6 : "La contrasenia debe tener al menos 6 caracteres";
        assert contrasenia.length() <= 12 : "La contrasenia no puede tener mas de 12 caracteres";
        assert contrasenia.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,10}$") : "No cumple con las condiciones de contrasenia"; //Regex que verifica que la contrasenia tenga al menos una mayuscula, un numero y que no tenga espacios en blanco

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

    /**
     * Metodo que establece el estado de un mozo
     * @param mozo
     * @param estado
     *
     * <b>Pre:</b>
     * mozo != null <br>
     * estado != null <br>
     *
     * <b>Post:</b>
     * Se establece el estado del mozo recibido. <br>
     */
    public void establecerEstadoMozo(Mozo mozo, Estado estado) {
        assert mozo != null : "El mozo no puede ser nulo";
        assert estado != null : "El estado no puede ser nulo";

        mozo.setEstado(estado);

        assert mozo.getEstado() == estado : "El estado del mozo no se establecio correctamente";
    }

    /**
     * Metodo que asigna mesa a un mozo
     * @param mozo
     * @param mesa
     *
     */
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
