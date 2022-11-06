package controladores;

import excepciones.ProductoInexistenteException;
import modelos.Producto;
import modelos.Sistema;
import vistas.GestionarProductos;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GestionarProductosController extends Controller<GestionarProductos> {

    public GestionarProductosController() {
        super(new GestionarProductos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equalsIgnoreCase("eliminarProducto")) {
            Producto producto = vista.getProductoSeleccionado();

            if (producto == null) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto para eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro que desea eliminar el producto " + producto.getNombre() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    try {
                        Sistema.getInstancia().eliminarProducto(producto);
                    } catch (ProductoInexistenteException ex) {
                        JOptionPane.showMessageDialog(vista, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (cmd.equalsIgnoreCase("crearProducto")) {
            Principal.getInstancia().setControladorActual(new CrearProductoController());
        } else if (cmd.equalsIgnoreCase("volver")) {
            Principal.getInstancia().setControladorActual(new AdministradorController());
        }
    }
}
