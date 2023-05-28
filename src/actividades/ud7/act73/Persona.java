package actividades.ud7.act73;

import java.io.Serializable;

public class Persona implements Serializable {
    protected String nombre;
    protected Integer edad;
    protected Persona padre;
    protected Direccion direccion;

    public Persona() {}

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, Integer edad, Persona padre, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.padre = padre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Persona getPadre() {
        return padre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
