package modelo;

public class Administrador extends Operario {
    private boolean establecioContrasena;

    public Administrador(String nombre, String apellido, String nombreUsuario, String contrasenia, boolean activo, boolean establecioContrasena) {
        super(nombre, apellido, nombreUsuario, contrasenia, activo);
        this.establecioContrasena = establecioContrasena;
    }
}
