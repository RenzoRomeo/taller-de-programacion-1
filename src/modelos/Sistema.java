package modelos;

import java.util.List;
import java.util.Map;

public class Sistema {
    private String nombreLocal;
    private List<Mozo> mozos;
    private List<Mesa> mesas;
    private List<Producto> productos;
    private List<Operario> operarios;
    private Sueldo sueldo;
    private Map<Mozo, List<Mesa>> asignacionMesas;
    private Map<Mesa, Comanda> comandas;
    private List<Promocion> promociones;
}
