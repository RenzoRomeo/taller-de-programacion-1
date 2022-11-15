package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import modelo.Operario;

class ConstructorOperarioTest {

	@Before
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Operario operario = new Operario("Juan", "Perez", "Juan", "Juan123");
		assertEquals("Juan", operario.getNombre(), "El nombre no se asigno correctamente");
		assertEquals("Perez", operario.getApellido(), "El apellido no se asigno correctamente");
		assertEquals("Juan", operario.getNombreUsuario(), "El nombre de usuario no se asigno correctamente");
		assertEquals("Juan123", operario.getContrasenia(), "La contrasenia no se asigno correctamente");
	}

}
