package actividades.ud8.actsDiapositivas.conexionDB;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "coche")
public class Car implements Serializable {
    @Embedded
    private Manufacturer manufacturer;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "refSeq")
    @SequenceGenerator(initialValue = 50, allocationSize = 10, name = "refSeq")
    private Integer ref;

    private String color;
    private String model;
    private String year;

    public Car() {}

    public Car(String manufacturer,String model, String year, String color) {
        this.manufacturer = new Manufacturer(manufacturer);
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Integer getRef() {
        return ref;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setRef(Integer ref) {
        this.ref = ref;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
