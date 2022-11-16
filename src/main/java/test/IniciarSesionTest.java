package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioNoExisteException;
import modelo.Operario;
import modelo.Sistema;

class IniciarSesionTest {

	private static Sistema sistema;
	
	@BeforeAll
	static void setUp() throws Exception {
		sistema = Sistema.getInstance();
		Operario juan = new Operario("Juan", "Perez", "Juan", "Juan123");
		sistema.agregarOperario(juan);
		Operario jose = new Operario("Jose", "Perez", "Jose", "Jose123");
		jose.setActivo(false);
		sistema.agregarOperario(jose);
	}

	@Test
	void inicioSesionCorrecto() {
		try {
			sistema.iniciarSesionOperario("Juan", "Juan123");
		} catch (UsuarioInactivoException | UsuarioNoExisteException | ContraseniaIncorrectaException e) {
			fail("El operario deberia haber iniciado sesion correctamente");
		}
	}
	
	@Test
	void usuarioInexistente() {
		try {
			sistema.iniciarSesionOperario("Jorge", "Juan123");
			fail("El operario no deberia existir");
		}  catch (UsuarioInactivoException | ContraseniaIncorrectaException e) {
			fail("El operario no deberia existir");
		} catch (UsuarioNoExisteException e) {
			
		}
	}
	
	@Test
	void usuarioInactivo() {
		try {
			sistema.iniciarSesionOperario("Jose", "Jose123");
			fail("El operario no deberia estar activo");
		}  catch (UsuarioNoExisteException | ContraseniaIncorrectaException e) {
			fail("El operario no deberia estar activo");
		} catch (UsuarioInactivoException e) {
			
		}
	}	
	
	@Test
	void contraseniaIncorrecta() {
		try {
			sistema.iniciarSesionOperario("Juan", "Pepe");
			fail("La contrasenia no deberia ser correcta");
		}  catch (UsuarioNoExisteException | UsuarioInactivoException e) {
			fail("La contrasenia no deberia ser correcta");
		} catch (ContraseniaIncorrectaException e) {
			
		}
	}
	
	@Test
	void contraseniaIncorrectaOUsuarioInactivo() {
		try {
			sistema.iniciarSesionOperario("Jose", "Pepe");
			fail("El usuario no deberia poder iniciar sesion");
		}  catch (UsuarioNoExisteException e) {
			fail("El usuario deberia existir");
		} catch (UsuarioInactivoException | ContraseniaIncorrectaException e) {
			
		}
	}
}
