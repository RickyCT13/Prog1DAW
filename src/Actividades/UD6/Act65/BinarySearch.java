package Actividades.UD6.Act65;

import java.util.Arrays;

public class BinarySearch {
    /**
     * @param a el array donde vamos a buscar.
     * @param element el elemento que queremos buscar en el array.
     * @return el índice en el que se encuentra el elemento o -1 si este no se encuentra en el array.
     */
    public static int search(int[] a, int element) {
        /** pos será el índice del elemento en medio del array o el más cercano.
         * Será siempre la parte entera de la longitud entre 2.*/
        int pos = a.length / 2;
        /** from y to serán los parametros introducidos cuando invoquemos el método copyOfRange. */
        int from = 0, to = a.length;
        /** Aquí tenemos los dos casos base del método: Cuando el elemento no se encuentra en el array
         * (Ya no quedan elementos para inspeccionar) y cuando el elemento se encuentre en la posicion pos
         * (es decir, se ha encontrado una solución)*/
        if (a.length == 0) {
            return -1;
        }
        if (Integer.compare(a[pos], element) == 0) {
            return pos;
        }
        /** Aquí, si el elemento en o cerca de la mitad del array es mayor o menor que el objetivo, los
         * parámetros from y to se modifican, por lo que no se tendrán en cuenta los elementos fuera del rango*/
        switch (Integer.compare(a[pos], element)) {
            case 1:
                to = pos;
                break;
            case -1:
                from = pos + 1;
                break;
        }
        return from + search(Arrays.copyOfRange(a, from, to), element);
    }
}
