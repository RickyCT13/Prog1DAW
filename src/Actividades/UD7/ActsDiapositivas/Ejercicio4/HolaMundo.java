package Actividades.UD7.ActsDiapositivas.Ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduzca su nombre completo: ");
            String fullName = scanner.nextLine();
            System.out.println("Introduzca su edad: ");
            int age = scanner.nextInt();
            System.out.println("Hola, " + fullName.split("\s")[0] + "!");
        }
        catch (InputMismatchException mismatch) {
            System.err.println("Error: tipo de dato incorrecto");
        }

    }
}
