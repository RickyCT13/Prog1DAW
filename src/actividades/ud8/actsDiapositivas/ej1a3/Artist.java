package actividades.ud8.actsDiapositivas.ej1a3;

import javax.persistence.Embeddable;

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
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }
}
