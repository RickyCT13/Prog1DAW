package Actividades.UD8.ActsDiapositivas.ConexionDB;

import javax.persistence.Embeddable;

@Embeddable
public class Manufacturer {
    private String name;

    public Manufacturer() {}
    public Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
