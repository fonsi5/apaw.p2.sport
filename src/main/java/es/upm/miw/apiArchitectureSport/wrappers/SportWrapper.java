package es.upm.miw.apiArchitectureSport.wrappers;

public class SportWrapper {
    private int id;

    private String nombre;

    public SportWrapper() {
    }

    public SportWrapper(int id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
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
        return "{\"id\":" + id + ",\"name\":\"" + nombre + "\"}";
    }

}
