package dao;

import java.util.Arrays;
import java.util.List;
import modelo.Demo;

public class DemoImpl {

    public List<Demo> listarBien() throws Exception {

        return Arrays.asList(
                new Demo(1, "hola"),
                new Demo(2, "mundo")
        );
    }
    public List<Demo> listarMal() throws Exception {

        return null;
    }
    
    public void insertar() throws Exception {

    }
    public void editar() throws Exception {

    }
}
