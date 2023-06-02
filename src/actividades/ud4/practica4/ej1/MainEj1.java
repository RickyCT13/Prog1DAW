package actividades.ud4.practica4.ej1;

import java.util.Arrays;

public class MainEj1 {
    public static void main(String[] args) {
        Geometry[] geometries = {
                new Triangle(12.30, 14.00, new Double[]{12d, 4d, 3d}, "Red"),
                new Triangle(1.50, 2.50, new Double[]{1.5, 2.6, 7.5}, "Red"),
                new Circle(7.5, "Yellow"),
                new Circle(5.0, "Yellow"),
                new Square(12.5, "Purple"),
                new Square(9.95, "Purple")
        };

        Double[] areas = calculateAllAreas(geometries);

        System.out.println("Array de formas original: \n" + Arrays.toString(geometries));
        System.out.println("Areas: " + Arrays.toString(areas));
        Geometry[] paintedGeometries = paintFirstOfType(geometries);
        System.out.println("Formas pintadas: " + Arrays.toString(paintedGeometries));
    }

    public static Double[] calculateAllAreas(Geometry[] geometries) {
        Double[] allAreas = new Double[geometries.length];
        for (int i = 0; i < geometries.length; i++) {
            allAreas[i] = geometries[i].calculateArea();
        }
        return allAreas;
    }

    public static Geometry[] paintFirstOfType(Geometry[] geometries) {
        Geometry[] cloned = geometries.clone();
        Class currentClass = cloned[0].getClass();
        cloned[0].paint("Blue");
        for (Geometry g:
             cloned) {
            if (g.getClass() != currentClass) {
                currentClass = g.getClass();
                g.paint("Blue");
            }
        }
        return cloned;
    }

}
