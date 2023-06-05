package actividades.ud4.practica4.ej2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String myText = "Hola, esto es un texto de prueba. Repito, texto de prueba...";
        System.out.println(differentWordCount(myText));
    }

    public static int differentWordCount(String text) {
        String convertedText = text.toLowerCase();
        String[] words = convertedText.split("\\W+");

        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        return uniqueWords.size();
    }
}
