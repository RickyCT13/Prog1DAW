package actividades.ud7.actsDiapositivas.ejercicio2;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Introduzca su nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        System.out.println("Hola " + nombre + "!");
    }
}
