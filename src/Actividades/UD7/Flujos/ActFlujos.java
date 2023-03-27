package Actividades.UD7.Flujos;

import java.io.IOException;
import java.util.Scanner;

public class ActFlujos {
    /* Pedirle al usuario que introduzca 3 caracteres por teclado
    * Luego, los imprimimos concatenados:
    * 1 con write, otro con print y otro con println */
    public static void main(String[] args) throws IOException {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Introduzca 3 caracteres:");
        String[] chars = scanInput.nextLine().split("\s");

    }
}
