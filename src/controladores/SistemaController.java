package controladores;

import jdk.jshell.execution.Util;
import modelo.Sistema;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.SistemaDTO;
import persistencia.UtilDTO;

import java.io.File;
import java.io.IOException;

public class SistemaController {
    private static SistemaController instance = null;
    private IPersistencia<SistemaDTO> persistencia = new PersistenciaBIN<SistemaDTO>();
    private static String fileName = "sistema.bin";

    private SistemaController() {

    }

    public static SistemaController getInstance() {
        if (instance == null) {
            instance = new SistemaController();
        }
        return instance;
    }

    public void iniciarSistema() {
        try{
            File file = new File(fileName);
            if(file.exists()){
                SistemaDTO sistemaDTO = persistencia.recuperar(fileName);
                UtilDTO.sistemaFromSistemaDTO(sistemaDTO);
            }
        } catch (IOException | ClassNotFoundException e1){
            e1.printStackTrace();
        }

    }

    public void cerrarSistema() {
        try{
            persistencia.persistir(fileName, UtilDTO.sistemaDTOFromSistema());
        } catch (IOException e) {
            System.out.println("Error al cerrar el sistema");
        }
    }
}
