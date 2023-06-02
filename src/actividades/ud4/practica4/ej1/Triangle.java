package actividades.ud4.practica4.ej1;

import java.security.InvalidParameterException;
import java.util.Objects;

public class Triangle extends Geometry {
    private Double base, height;
    private Double[] sides;
    private String color;

    public Triangle() {

    }

    public Triangle(Double base, Double height, Double[] sides) {
        this.base = base;
        this.height = height;
        this.sides = sides;
    }

    public Triangle(Double base, Double height, Double[] sides, String color) {
        this.base = base;
        this.height = height;
        this.sides = sides;
        paint(color);
    }

    public Double getBase() {
        return base;
    }

    public Double getHeight() {
        return height;
    }

    public Double[] getSides() {
        return sides;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setSides(Double[] sides) {
        this.sides = sides;
    }

    @Override
    public Double calculateArea() {
        return ((base * height) / 2);
    }

    @Override
    public Double calculatePerimeter() {
        return (sides[0] + sides[1] + sides[2]);
    }

    public String getColor() {
        return color;
    }

    @Override
    public void paint(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String info = "Triángulo" + "\nBase: " + base + "\nAltura: " + height;
        if (color != null) {
            info = info + "\nColor: " + color;
        }
        return "\n_______________________________________________\n" +
                info +
                "\n_______________________________________________\n";
    }
}
