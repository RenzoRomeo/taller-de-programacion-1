package modelos;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;

public class Operario {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contrasenia;
    private boolean activo;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
