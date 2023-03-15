package Actividades.UD6.Act63;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    /*Realiza un algoritmo que dado un conjunto de números,
    encuentre el número más grande.*/
    public static Integer greatestNumber(Collection<Integer> numbers) {
        Integer greatest = 0;
        for (Integer i:
             numbers) {
            if (i > greatest) {
                greatest = i;
            }
        }
        return greatest;
    }
}
