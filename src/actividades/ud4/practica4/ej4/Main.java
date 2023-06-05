package actividades.ud4.practica4.ej4;

public class Main {
    public static void main(String[] args) {
        System.out.println(validarDNI("12345678Z"));
    }
    public static boolean validarDNI(String input) {

        String formatoDNI = "^[0-9]{8}[A-Za-z]$";

        /* Bloque de control en caso de que se proporcione un NIE */
        if (input.startsWith("X")) {
            input = "0" + input.substring(1);
        } else if (input.startsWith("Y")) {
            input = "1" + input.substring(1);
        } else if (input.startsWith("Z")) {
            input = "2" + input.substring(1);
        }

        if (!input.matches(formatoDNI)) {
            return false;
        }

        int numero = Integer.parseInt(input.substring(0, 8));
        char letra = input.charAt(8);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return (letras.charAt(numero % 23) == letra);
    }
}
