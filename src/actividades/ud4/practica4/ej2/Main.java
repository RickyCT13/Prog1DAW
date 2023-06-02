package actividades.ud4.practica4.ej2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String myText = "Hola, esto es un texto de prueba. Repito, texto de prueba...";
        differentWordCount(myText);
    }

    public static void differentWordCount(String text) {
        String[] words = text.split("(\\.|\\,)*(\\s)|\\.+");
        Pattern pattern;
    }
}
