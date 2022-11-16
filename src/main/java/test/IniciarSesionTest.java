package test;

import excepciones.ContraseniaIncorrectaException;
import excepciones.UsuarioInactivoException;
import excepciones.UsuarioNoExisteException;
import modelo.Sistema;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.escenarios.Escenario1Sistema;

import static org.junit.jupiter.api.Assertions.fail;

class IniciarSesionTest {
	@BeforeAll
	static void setUp() {
		Escenario1Sistema.setUp();
	}

	@AfterAll
	static void tearDown() {
		Escenario1Sistema.tearDown();
	}

	@Test
	void inicioSesionCorrecto() {
		try {
			Sistema.getInstance().iniciarSesionOperario("Juan", "Juan123");
		} catch (UsuarioInactivoException | UsuarioNoExisteException | ContraseniaIncorrectaException e) {
			fail("El operario deberia haber iniciado sesion correctamente");
		}
	}
	
	@Test
	void usuarioInexistente() {
		try {
			Sistema.getInstance().iniciarSesionOperario("Jorge", "Juan123");
			fail("El operario no deberia existir");
		}  catch (UsuarioInactivoException | ContraseniaIncorrectaException e) {
			fail("El operario no deberia existir");
		} catch (UsuarioNoExisteException e) {
			
		}
	}
	
	@Test
	void usuarioInactivo() {
		try {
			Sistema.getInstance().iniciarSesionOperario("Jose", "Jose123");
			fail("El operario no deberia estar activo");
		}  catch (UsuarioNoExisteException | ContraseniaIncorrectaException e) {
			fail("El operario no deberia estar activo");
		} catch (UsuarioInactivoException e) {
			
		}
	}	
	
	@Test
	void contraseniaIncorrecta() {
		try {
			Sistema.getInstance().iniciarSesionOperario("Juan", "Pepe");
			fail("La contrasenia no deberia ser correcta");
		}  catch (UsuarioNoExisteException | UsuarioInactivoException e) {
			fail("La contrasenia no deberia ser correcta");
		} catch (ContraseniaIncorrectaException e) {
			
		}
	}
	
	@Test
	void contraseniaIncorrectaOUsuarioInactivo() {
		try {
			Sistema.getInstance().iniciarSesionOperario("Jose", "Pepe");
			fail("El usuario no deberia poder iniciar sesion");
		}  catch (UsuarioNoExisteException e) {
			fail("El usuario deberia existir");
		} catch (UsuarioInactivoException | ContraseniaIncorrectaException e) {
			
		}
	}
}
