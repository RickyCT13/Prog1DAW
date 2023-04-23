package Actividades.UD7.ActsDiapositivas.Ejercicio3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        byte[] b = new byte[5];
        try {
            System.in.read(b);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        String s = new String(b);
        System.out.println(s);
    }
    /* Este código imprimirá los
    primeros 5 bytes pasados por entrada */
}
