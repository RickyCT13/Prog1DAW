package Actividades.UD6.Act63;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(3);
        numbers.add(67);
        numbers.add(13);
        numbers.add(9);
        System.out.println(greatestNumber(numbers));

    }

    /* 1 y 2. Realiza un algoritmo que dado un conjunto de números,
    encuentre el número más grande. Después, calcula su complejidad
    usandola notación Big-O*/
    public static Integer greatestNumber(Collection<Integer> numbers) {
        Integer greatest = 0; // O(1)
        Iterator<Integer> it = numbers.iterator(); //O(1)
        while (it.hasNext()) { // Nº de op. dependiente de la longitud de 'numbers'
            if (it.next() > greatest) { //O(1)
                greatest = it.next(); //0(1)
            }
        }
        return greatest; // No añade complejidad
    }
    /* En total: O(1) + O(1) + (N * (0(1) + 0(1)) = O(2) + (N * O(2)) = O(2) + O(2 * n)
    * = O(N) */
    /*
    * 3. ¿Crees que influye la cantidad de números del conjunto en el tiempo que tardará tu
algoritmo en resolver el problema? ¿Podrías indicar cuál es el caso más favorable y el peor
caso?

	La cantidad de números está asociada al tamaño de la colección
	* y no tiene por qué ser siempre el mismo.

	El mejor caso es que la colección contenga solo un número, el peor
	*  es que el número mayor se encuentre al final y el caso medio es que
	*  se encuentre en cualquier otra posición.

    */
}
