package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.MesaNoExisteException;
import excepciones.UsuarioNoExisteException;
import modelo.Mesa;
import modelo.Operario;
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
	void mesaInexistente() {
		try {
			Mesa mesa2 = new Mesa(2, 10);
			sistema.eliminarMesa(mesa2);
			fail("Deberia haber lanzado una excepcion");
		} catch(MesaNoExisteException e) {
			
		}
	}

}
