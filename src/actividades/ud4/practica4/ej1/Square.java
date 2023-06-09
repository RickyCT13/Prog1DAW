package actividades.ud4.practica4.ej1;

public class Square extends Geometry implements Paintable {
    private Double sideLength;
    private String color;

    public Square() {

    }

    public Square(Double sideLength) {
        this.sideLength = sideLength;
    }

    public Square(Double sideLength, String color) {
        this.sideLength = sideLength;
        paint(color);
    }

    public Double getSideLength() {
        return sideLength;
    }

    public void setSideLength(Double sideLength) {
        this.sideLength = sideLength;
    }



    @Override
    public Double calculateArea() {
        return (sideLength * sideLength);
    }

    @Override
    public Double calculatePerimeter() {
        return (4 * sideLength);
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
        String info = "Cuadrado\n" + "Lado: " + sideLength;
        if (color != null) {
            info = info + "\nColor: " + color;
        }
        return "\n_______________________________________________\n" +
                info +
                "\n_______________________________________________\n";
    }
}
