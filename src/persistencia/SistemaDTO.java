package persistencia;

import modelo.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class SistemaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Administrador administrador = new Administrador();
    private String nombreLocal;
    private ArrayList<Mozo> mozos = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private HashMap<String, Operario> operarios = new HashMap<String, Operario>();
    private Sueldo sueldo;
    private HashMap<Mozo, ArrayList<Mesa>> asignacionMesas = new HashMap<>();
    private HashMap<Mesa, Comanda> comandas = new HashMap<>();
    private ArrayList<PromocionProducto> promocionesProducto = new ArrayList<>();
    private ArrayList<PromocionTemporal> promocionesTemporales = new ArrayList<>();

    public SistemaDTO() {
    }

    public SistemaDTO(Administrador administrador, String nombreLocal, ArrayList<Mozo> mozos, ArrayList<Mesa> mesas, ArrayList<Producto> productos, HashMap<String, Operario> operarios, Sueldo sueldo, HashMap<Mozo, ArrayList<Mesa>> asignacionMesas, HashMap<Mesa, Comanda> comandas, ArrayList<PromocionProducto> promocionesProducto, ArrayList<PromocionTemporal> promocionesTemporales) {
        this.administrador = administrador;
        this.nombreLocal = nombreLocal;
        this.mozos = mozos;
        this.mesas = mesas;
        this.productos = productos;
        this.operarios = operarios;
        this.sueldo = sueldo;
        this.asignacionMesas = asignacionMesas;
        this.comandas = comandas;
        this.promocionesProducto = promocionesProducto;
        this.promocionesTemporales = promocionesTemporales;
    }


    public Administrador getAdministrador() {
        return administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    public String getNombreLocal() {
        return nombreLocal;
    }
    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }
    public ArrayList<Mozo> getMozos() {
        return mozos;
    }
    public void setMozos(ArrayList<Mozo> mozos) {
        this.mozos = mozos;
    }
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    public void setOperarios(HashMap<String, Operario> operarios) {
        this.operarios = operarios;
    }
    public HashMap<String, Operario> getOperarios() {
        return operarios;
    }
    public Sueldo getSueldo() {
        return sueldo;
    }
    public void setSueldo(Sueldo sueldo) {
        this.sueldo = sueldo;
    }
    public HashMap<Mozo, ArrayList<Mesa>> getAsignacionMesas() {
        return asignacionMesas;
    }
    public void setAsignacionMesas(HashMap<Mozo, ArrayList<Mesa>> asignacionMesas) {
        this.asignacionMesas = asignacionMesas;
    }
    public HashMap<Mesa, Comanda> getComandas() {
        return comandas;
    }
    public void setComandas(HashMap<Mesa, Comanda> comandas) {
        this.comandas = comandas;
    }
    public ArrayList<PromocionProducto> getPromocionesProducto() {
        return promocionesProducto;
    }
    public void setPromocionesProducto(ArrayList<PromocionProducto> promocionesProducto) {
        this.promocionesProducto = promocionesProducto;
    }
    public ArrayList<PromocionTemporal> getPromocionesTemporales() {
        return promocionesTemporales;
    }
    public void setPromocionesTemporales(ArrayList<PromocionTemporal> promocionesTemporales) {
        this.promocionesTemporales = promocionesTemporales;
    }


}