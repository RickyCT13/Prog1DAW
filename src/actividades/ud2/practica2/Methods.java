package actividades.ud2.practica2;

public class Methods {
    /**
     * Este método devuelve si un número es primo o no.
     * @param n El número entero a evaluar.
     * @return true si es primo, false si no lo es.
     */
    protected static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Genera un número aleatorio entre dos números inclusives.
     * @param min El límite inferior del rango.
     * @param max El límite superior del rango.
     * @return Un numero entero aleatorio cuyo valor se encuentra entre min y max (inclusives).
     */
    protected static int newRandomNumber(int min, int max) {
        return (int) (Math.random()*(min + max));
    }

    /**
     * Se asigna a la variable RandomNumber un número aleatorio entre 1 y 100. Posteriormente, se averigua
     * si es primo o no. El resultado se imprime por pantalla.
     */
    protected static void randomIsPrime() {
        int randomNumber = Methods.newRandomNumber(1, 100);
        if (Methods.isPrime(randomNumber)) {
            System.out.println("El número " + randomNumber + " es primo.");
        }
        else {
            System.out.println("El número " + randomNumber + " NO es primo.");
        }
    }
}
