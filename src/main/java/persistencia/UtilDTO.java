package persistencia;

import modelo.Sistema;

public class UtilDTO {
    public static SistemaDTO sistemaDTOFromSistema() {
        SistemaDTO sistemaDTO = new SistemaDTO();
        sistemaDTO.setOperarios(Sistema.getInstance().getOperarios());
        sistemaDTO.setAdministrador(Sistema.getInstance().getAdministrador());
        sistemaDTO.setNombreLocal(Sistema.getInstance().getNombreLocal());
        sistemaDTO.setMozos(Sistema.getInstance().getMozos());
        sistemaDTO.setMesas(Sistema.getInstance().getMesas());
        sistemaDTO.setProductos(Sistema.getInstance().getProductos());
        sistemaDTO.setSueldo(Sistema.getInstance().getSueldo());
        sistemaDTO.setAsignacionMesas(Sistema.getInstance().getAsignacionMesas());
        sistemaDTO.setComandas(Sistema.getInstance().getComandas());
        sistemaDTO.setPromocionesProducto(Sistema.getInstance().getPromocionesProducto());
        sistemaDTO.setPromocionesTemporales(Sistema.getInstance().getPromocionesTemporales());
        return sistemaDTO;
    }
    public static Sistema sistemaFromSistemaDTO(SistemaDTO sistemaDTO) {
        Sistema sistema = Sistema.getInstance();
        sistema.setOperarios(sistemaDTO.getOperarios());
        sistema.setAdministrador(sistemaDTO.getAdministrador());
        sistema.setNombreLocal(sistemaDTO.getNombreLocal());
        sistema.setMozos(sistemaDTO.getMozos());
        sistema.setMesas(sistemaDTO.getMesas());
        sistema.setProductos(sistemaDTO.getProductos());
        sistema.setSueldo(sistemaDTO.getSueldo());
        sistema.setAsignacionMesas(sistemaDTO.getAsignacionMesas());
        sistema.setComandas(sistemaDTO.getComandas());
        sistema.setPromocionesProducto(sistemaDTO.getPromocionesProducto());
        sistema.setPromocionesTemporales(sistemaDTO.getPromocionesTemporales());
        return sistema;
    }
}
