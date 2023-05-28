package actividades.ud7.serializacion;

import java.io.Serializable;

public class Persona implements Serializable {
    private String name;
    private int age;
    private Persona parent;
    public Persona() {}
    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Persona getParent() {
        return parent;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
