package Actividades.UD5.A53Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Enunciado: Dado un array de números enteros, escriba un programa en Java que use un objeto Map para contar el número de veces que cada número aparece en el array. El programa debe imprimir los resultados en orden ascendente según el valor del número. */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {2, 5, 5, 7, 13, 12, 2, 7, 6, 6};
        Integer[] numsSortAsc = nums.clone();
        Arrays.sort(numsSortAsc);

        Map<Integer, Integer> numCounts = new HashMap<>();
        for (Integer number : numsSortAsc) {
            numCounts.put(number, numCounts.getOrDefault(number, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            System.out.println("El número " + value + " aparece en el array " + count + " veces.");
        }
    }
}
