package actividades.ud4.practica4.ej3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer[] randomNumbers = new Integer[100];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = ((int) (Math.random()*1001));
        }
        System.out.println("Se han generado 100 números aleatorios.");
        Arrays.sort(randomNumbers);
        System.out.println(Arrays.toString(randomNumbers));
        Scanner scanner = new Scanner(System.in);
        String options = "Seleccione una opción: \n" +
                "1. Seleccionar el mayor de los números" + "\n" +
                "2. Seleccionar el menor de los números" + "\n" +
                "3. Obtener la suma de todos los números" + "\n" +
                "4. Obtener la media de los números" + "\n" +
                "5. Sustituir el valor de un elemento por otro" + "\n" +
                "6. Salir" + "\n" +
                "->";
        System.out.println(options);
        int input = scanner.nextInt();
        while(input != 6) {
            switch (input) {
                case 1:
                    System.out.println(randomNumbers[randomNumbers.length - 1]);
                    break;
                case 2:
                    System.out.println(randomNumbers[0]);
                    break;
                case 3:
                    System.out.println(sumOfElements(randomNumbers));
                    break;
                case 4:
                    System.out.println((sumOfElements(randomNumbers) / randomNumbers.length));
                    break;
                case 5:
                    System.out.println("Introduzca el elemento que quiere reemplazar:");
                    Integer oldValue = scanner.nextInt();
                    System.out.println("Introduzca el nuevo valor:");
                    Integer newValue = scanner.nextInt();
                    replaceElement(randomNumbers, oldValue, newValue);
                    break;
            }
            System.out.println(options);
            input = scanner.nextInt();
        }
    }
    public static int sumOfElements(Integer[] numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void replaceElement(Integer[] numbers, Integer oldValue, Integer newValue) {
        int index = Arrays.binarySearch(numbers, oldValue);
        if (index >= 0) {
            numbers[index] = newValue;
            System.out.println("Se ha reemplazado el valor con éxito");
        }
        else System.out.println("El elemento que ha especificado no se encuentra en el array. Pruebe con otro");
    }
}
