package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenciaBIN<E> implements IPersistencia<E> {

    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    private ObjectOutputStream objectoutput;
    private ObjectInputStream objectinput;

    public void abrirInput(String nombre) throws IOException {
        fileinput = new FileInputStream(nombre);
        objectinput = new ObjectInputStream(fileinput);

    }

    public void abrirOutput(String nombre) throws IOException {
        fileoutput = new FileOutputStream(nombre);
        objectoutput = new ObjectOutputStream(fileoutput);

    }

    public void cerrarOutput() throws IOException {
        if (objectoutput != null)
            objectoutput.close();

    }

    public void cerrarInput() throws IOException {
        if (objectinput != null)
            objectinput.close();

    }

    public void escribir(E serializable) throws IOException {
        if (objectoutput != null)
            objectoutput.writeObject(serializable);
    }

    public E leer() throws IOException, ClassNotFoundException {
        E serializable = null;
        if (objectinput != null)
            serializable = (E) objectinput.readObject();
        return serializable;
    }

    @Override
    public void persistir(String nombre, E objeto) throws IOException {
        this.abrirOutput(nombre);
        this.escribir(objeto);
        this.cerrarOutput();

    }

    @Override
    public E recuperar(String nombre) throws IOException, ClassNotFoundException {
        E objeto = null;

        this.abrirInput(nombre);
        objeto = this.leer();
        this.cerrarInput();

        return objeto;
    }

}
