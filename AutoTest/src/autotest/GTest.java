package autotest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica queobtiene los metodos de una clase, selecciona las que
 * devuelven List y las ejecuta, si al ejecutar devuelve un null es pq no está
 * funcionando bien las consultas
 *
 * @author Martín Samán
 * @param <T> clase dao, clase modelo
 */
public class GTest<T> {

    Class<T> generico;
    Class<T> modelo;

    public GTest(Class<T> generico, Class<T> modelo) {
        this.generico = generico;
        this.modelo = modelo;
    }

    public List<Method> obtenerMetodos() {
        List<Method> listaMetodos = new ArrayList<>();
        Class clase = generico;
        System.out.println("Métodos obtenidos de " + generico.getName());
        for (Method metodo : clase.getDeclaredMethods()) {
            int modifiers = metodo.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                listaMetodos.add(metodo);
                System.out.println(metodo.getName());
            }
        }
        System.out.println("--");
        return listaMetodos;
    }

    public void ejecutarMetodos() throws ClassNotFoundException, InstantiationException {
        for (Method metodo : this.obtenerMetodos()) {
            if (metodo.getReturnType().equals(Class.forName("java.util.List"))) {
                metodo.setAccessible(true);

                System.out.println(metodo.getName() + " es de tipo consulta");

                try {
                    Object devuelto = metodo.invoke(generico.newInstance());
                    if (devuelto == null) {
                        System.out.println("[ERROR] Método (" + metodo.getName() + ") no devolvió nada.");
                    } else {
                        System.out.println("[EXITO] Método (" + metodo.getName() + ") devolvió " + devuelto);
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    System.out.println("[ERROR] " + metodo.getName() + " -> " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

}
