package Actividades.UD8.ActsDiapositivas.Ej1a3;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Artist {

    private String name;
    public Artist() {}
    public Artist(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artista: " + name;
    }
}
