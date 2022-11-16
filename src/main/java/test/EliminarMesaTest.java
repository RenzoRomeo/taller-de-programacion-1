package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MesaNoExisteException;
import modelo.Mesa;
import modelo.Sistema;
import test.escenarios.Escenario1Sistema;

class EliminarMesaTest {

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
	void mesaEliminada() {
		try {
			Mesa mesa1 = Escenario1Sistema.getMesa1();
			sistema.eliminarMesa(mesa1);
			assertFalse(sistema.getMesas().contains(mesa1), "La mesa deberia haberse eliminado");
		} catch (MesaNoExisteException e) {
			fail("La mesa deberia existir");
		}
	}

	@Test
	void mesaInexistente() {
		try {
			Mesa mesa2 = new Mesa(2, 10);
			sistema.eliminarMesa(mesa2);
			fail("Deberia haber lanzado una excepcion");
		} catch(MesaNoExisteException e) {
			
		}
	}

}
