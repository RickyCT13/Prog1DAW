package actividades.ud4.practica4.ej1;

public class Circle extends Geometry implements Paintable {
    private Double radius;
    private String color;

    public Circle() {}

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Circle(Double radius, String color) {
        this.radius = radius;
        paint(color);
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return (Math.PI * radius * radius);
    }

    @Override
    public Double calculatePerimeter() {
        return (2 * radius * Math.PI);
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
        String info = "Círculo \n" + "Radio: " + radius;
        if (color != null) {
            info = info + "\nColor: " + color;
        }
        return "\n_______________________________________________\n" +
                info +
                "\n_______________________________________________\n";
    }
}
