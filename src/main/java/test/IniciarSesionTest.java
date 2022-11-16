package test;

import excepciones.*;
import modelos.*;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class IniciarSesionTest {

    private static Operario operario = new Operario("Teo", "Ramos", "teoramite","Teo1234");;


    @BeforeAll
    public static void setUp() {
        try {
            Sistema.inicializarSistema("McDonalds");
        } catch (SistemaYaInicializadoException e) {
            fail("Sistema no deberia estar inicializado");
        }
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);

        try {
            Sistema.getInstancia().agregarOperario(operario);
        } catch (OperarioExistenteException e) {
            fail("Operario no deberia existir");
        } catch (OperacionNoAutorizadaException e) {
            fail("Operacion debio ser autorizada");
        }



    }

    @Test
    public void datosCorrectosTest(){
        try {
                operario.iniciarSesion("Teo1234");
        } catch (UsuarioInactivoException e) {
                fail("Usuario debio estar activo");
        } catch (ContraseniaIncorrectaException e) {
                fail("Contrasenia debio ser correcta");
        }
    }

    @Test
    public void contraseniaIncorrectaTest(){
        try {
            operario.iniciarSesion("Teo123");
            fail("Debio lanzar excepcion de contrasenia incorrecta");
        }
        catch (UsuarioInactivoException e) {
            fail("Usuario debio estar activo");
        }
        catch (ContraseniaIncorrectaException e) {
            System.out.println("Contrasenia incorrecta");
            System.out.println(Sistema.getInstancia());
        }
    }

    @Test
    public void usuarioInactivoTest(){
        try {
            operario.setActivo(false);
            operario.iniciarSesion("Teo1234");
            fail("Debio lanzar excepcion de usuario inactivo");
        }
        catch (UsuarioInactivoException e) {
            System.out.println("Usuario inactivo");
        }
        catch (ContraseniaIncorrectaException e) {
            fail("Contrasenia debio ser correcta");
        }
    }
}
