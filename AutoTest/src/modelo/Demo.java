package modelo;

public class Demo {

    private int id;
    private String nombre;

    public Demo() {
    }

    public Demo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Demo{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
