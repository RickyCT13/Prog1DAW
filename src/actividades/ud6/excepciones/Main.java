package actividades.ud6.excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         tryAndCatch();
         handleIOs();
        */
        noDuplicates();
    }

    private static void noDuplicates() {
        try {
            List<Integer> myList = new ArrayList<>();
            addTolist(myList,1);
            addTolist(myList,2);
            addTolist(myList,2);
            System.out.println("A");
        }
        catch (ElementAlreadyInListException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        catch (IllegalArgumentException ia) {
            System.err.println("huh?");
        }
        finally {
            System.out.println("Fin.");
        }
    }

    private static void handleIOs() {
        try {
            readFromPath("/Users/1DAW_2223_11/IdeaProjects/Prog 1DAW/src/Actividades/UD6/Excepciones/hola.txt");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: Archivo no encontrado");
            ex.printStackTrace();
        }
        catch (IOException io) {
            System.out.println("Error desconocido relacionado con la entrada y salida.");
            io.printStackTrace();
        }
        finally {
            System.out.println("Fin de lectura.");
        }
    }

    private static void extracted() {
        // Produce código que lance un NullPointerException
        List<String> list = null;
        list.add("Hola?");
        System.out.println(list);
    }

    private static void tryAndCatch() {
        System.out.println("Inicio de la división");
        // Try, el código susceptible a excepciones.
        try {
            int a = 5;
            int b = 0;
            System.out.println("El resultado es : " + division(a, b));
        }
        catch (ArithmeticException ex) {
            System.out.println("Imposible dividir por 0.");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        /*
         Si fuese de tipo Excepción, se volvería más difícil averiguar
         De qué tipo es. Por eso, si vamos a introducir tal captura de
         código, deberíamos hacerlo al final. (Se tiene en cuenta el primer catch)
        */
        finally {
            System.out.println("Fin de la división.");
        }
    }

    private static int division(int dividend, int divider) throws ArithmeticException {
        return (dividend / divider);
    }

    private static void readFromPath(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        System.out.println(fileReader.read());
        fileReader.close();
    }

    /*
     Método que meta un número en una lista, y si ya se encuentra
     en esta, que lance una IllegalArgumentException.
     */
    private static void addTolist(List<Integer> list, Integer element) throws ElementAlreadyInListException {
        if (list.contains(element)) {
            throw new ElementAlreadyInListException("Este elemento ya está en la lista!");
        }
        else list.add(element);
    }

}

