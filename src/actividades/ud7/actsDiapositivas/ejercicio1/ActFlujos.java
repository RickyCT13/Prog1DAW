package actividades.ud7.actsDiapositivas.ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class ActFlujos {
    /* Pedirle al usuario que introduzca 4 caracteres por teclado
    * Luego, los imprimimos concatenados:
    * 1 con write, otro con print y otro con println y otro con print f */
    public static void main(String[] args) throws IOException {
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Introduzca 4 caracteres:");
        String[] chars = scanInput.nextLine().split("\s");
        System.out.write(chars[0].getBytes());
        System.out.print(chars[1]);
        System.out.println(chars[2]);
        System.out.printf("%s", chars[3]);
    }
}
