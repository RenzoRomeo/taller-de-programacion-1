package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MozoNoExisteException;
import modelo.Mozo;
import modelo.Sistema;
import test.escenarios.Escenario1Sistema;

class EliminarMozoTest {

	private static Sistema sistema;
	
	@BeforeAll
	static void setUp() throws Exception {
		Escenario1Sistema.setUp();
		sistema = Sistema.getInstance();
	}

	@AfterAll
	static void tearDown() throws Exception {
		Escenario1Sistema.tearDown();
	}

	@Test
	void mozoEliminado() {
		try {
			Mozo mozoEliminado = Escenario1Sistema.getMozoAlberto();
			sistema.eliminarMozo(mozoEliminado);
			assertFalse(sistema.getMozos().contains(mozoEliminado), "El mozo se deberia haber eliminado");
		} catch (MozoNoExisteException e) {
			fail("El mozo deberia existir");
		}
	}
	
	@Test
	void mozoInexistente() {
		try {
			Mozo mozoEliminado = new Mozo("Damian", "Garcia", new Date(1986, 10, 10), 0);
			sistema.eliminarMozo(mozoEliminado);
			fail("El mozo no deberia existir");
		} catch (MozoNoExisteException e) {
						
		}
	}

}
