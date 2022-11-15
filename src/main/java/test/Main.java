package test;

import excepciones.*;
import modelos.Operario;
import modelos.Sistema;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.fail;

public class Main {
    public static void main(String[] args) throws SistemaYaInicializadoException, OperarioExistenteException, OperacionNoAutorizadaException {
        Operario operario = new Operario("Teo", "Ramos", "teoramite","Teo1234");;
        System.out.println("Hello World!");
        Sistema.inicializarSistema("McDonalds");
        System.out.println(Sistema.isInicializado());
        Sistema.getInstancia().agregarOperario(operario);
        try {
            operario.iniciarSesion("Teo1234");
        } catch (UsuarioInactivoException e) {
            fail("Usuario debio estar activo");
        } catch (ContraseniaIncorrectaException e) {
            fail("Contrasenia debio ser correcta");
        }
    }
}
