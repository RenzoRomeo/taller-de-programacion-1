package modelos;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;

/**
 * Clase que representa a un operario del sistema.
 * <b>Inv:</b>
 * nombre != null
 * nombre != ""
 * nombre permance constante
 * apellido != null
 * apellido != ""
 * apellido permance constante
 * nombreUsuario != null
 * nombreUsuario != ""
 * contrasenia != null
 * contrasenia.length() >= 6
 * contrasenia.length() <= 12
 * contrasenia contiene al menos un numero
 * contrasenia contiene al menos una letra mayuscula
 */
public class Operario {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasenia;
    private boolean activo;

    /**
     * Constructor de la clase Operario.
     * @param nombre Nombre del operario.
     * @param apellido Apellido del operario.
     * @param nombreUsuario Nombre de usuario del operario.
     * @param contrasenia Contraseña del operario.
     * <b>Pre:</b>
     * nombre != null
     * nombre != ""
     * apellido != null
     * apellido != ""
     * nombreUsuario != null
     * nombreUsuario != ""
     * contrasenia != null
     * contrasenia.length() >= 6
     * contrasenia.length() <= 12
     * contrasenia contiene al menos un numero
     * contrasenia contiene al menos una letra mayuscula
     * <b>Post:</b>
     * Se crea un nuevo operario con los datos ingresados y con el estado activo.
     */
    public Operario(String nombre, String apellido, String nombreUsuario, String contrasenia) {
        assert nombre != null;
        assert nombre != "";
        assert apellido != null;
        assert apellido != "";
        assert nombreUsuario != null;
        assert nombreUsuario != "";
        assert contrasenia != null;
        assert contrasenia.length() >= 6;
        assert contrasenia.length() <= 12;
        assert contrasenia.matches(".*[0-9].*");
        assert contrasenia.matches(".*[A-Z].*");

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

    }

    public void asignarMesa(Mozo mozo, Mesa mesa) {

    }

    /**
     * Inicia sesion a un operario dentro del sistema.
     * @param contrasenia La contraseña del operario.
     * @throws UsuarioInactivoException Si el usuario se encuentra inactivo.
     * @throws ContraseniaIncorrectaException Si la contraseña ingresada es incorrecta.
     */
    public void iniciarSesion(String contrasenia) throws UsuarioInactivoException, ContraseniaIncorrectaException {
        if(!activo) {
            throw new UsuarioInactivoException(this);
        }

        if(!this.contrasenia.equals(contrasenia)) {
            throw new ContraseniaIncorrectaException();
        }

        // Acciones si se loguea bien
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
