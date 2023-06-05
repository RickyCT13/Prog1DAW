package actividades.ud4.practica4.ej5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String myText = "Hola, esto es un texto de prueba. Repito, texto de prueba...";
        String word = "Prueba";
        System.out.println("Número de ocurrencias de la palabra \'" + word + "\': " + countWordOcurrences(myText, word, true));
    }

    public static int countWordOcurrences(String text, String word, boolean ignoreCase) {
        Pattern pattern;
        if (ignoreCase) {
            pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        }
        else {
            pattern = Pattern.compile(word);
        }
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while(matcher.find()) {
            count++;
        }
        return count;
    }
}
