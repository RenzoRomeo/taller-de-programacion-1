package test;

import excepciones.OperacionNoAutorizadaException;
import excepciones.ProductoExistenteException;
import excepciones.ProductoInexistenteException;
import excepciones.SistemaYaInicializadoException;
import modelos.Producto;
import modelos.PromocionProducto;
import modelos.Sistema;
import modelos.enums.Dia;
import modelos.enums.ModoOperacion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

public class AgregarPromocionProductoTest {

    private static Producto burger = new Producto("Hamburguesa", 80, 100, 10);
    private static Producto papas = new Producto("Papas", 100, 150, 20);
    private static ArrayList<Dia> diasPromo = new ArrayList<Dia>();


    @BeforeAll
    public static void setUp() throws ProductoExistenteException, OperacionNoAutorizadaException {
        try {
            Sistema.inicializarSistema("McDonalds");
        } catch (SistemaYaInicializadoException e) {
            fail("Sistema no deberia estar inicializado");
        }
        Sistema.getInstancia().setModoOperacion(ModoOperacion.ADMINISTRADOR);
        Sistema.getInstancia().agregarProducto(papas);
        diasPromo.add(Dia.LUNES);
        diasPromo.add(Dia.MIERCOLES);
    }

    @Test
    public void datosCorrectosTest() {
        PromocionProducto promocionProducto = new PromocionProducto(true, true, 10, 15, diasPromo);
        try {
            Sistema.getInstancia().agregarPromocionProducto(papas, promocionProducto);
        } catch (ProductoInexistenteException e) {
        }
    }

    @Test
    public void productoInexistenteException() {
        PromocionProducto promocionProducto = new PromocionProducto(true, true, 10, 15, diasPromo);
        try {
            Sistema.getInstancia().agregarPromocionProducto(burger, promocionProducto);
            fail("Deberia haber excepcion");
        } catch (ProductoInexistenteException e) {
            System.out.println("Producto inexistente");
        }
    }



}
