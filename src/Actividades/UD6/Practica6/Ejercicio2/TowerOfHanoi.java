package Actividades.UD6.Practica6.Ejercicio2;

public class TowerOfHanoi {
    public static void initialize(Integer n, Rod sourceRod, Rod destRod, Rod auxRod) {
        /* Asignación de nombres a las varillas */
        sourceRod.setName("A");
        destRod.setName("C");
        auxRod.setName("B");
        /* Se colocan los discos en la varilla de origen. */
        for (int i = n; i > 0; i--) {
            sourceRod.push(i);
        }
    }

    public static void hanoi(Integer n, Rod sourceRod, Rod destRod, Rod auxRod) {
        /* Caso base */
        if (n == 1) {
            moveDisk(n, sourceRod, destRod);
        }
        else {
            hanoi(n - 1, sourceRod, auxRod, destRod);
            moveDisk(n, sourceRod, destRod);
            hanoi(n - 1, auxRod, destRod, sourceRod);
        }
    }

    public static void solve(Integer n, Rod sourceRod, Rod destRod, Rod auxRod) {
        initialize(n, sourceRod, destRod, auxRod);
        hanoi(n, sourceRod, destRod, auxRod);
    }

    private static void moveDisk(Integer n, Rod sourceRod, Rod destRod) {
        if (destRod.empty() || sourceRod.peek().compareTo(destRod.peek()) < 0) {
            destRod.push(sourceRod.pop());
            printMove(n, sourceRod, destRod);
        }
    }

    private static void printMove(Integer n, Rod sourceRod, Rod destRod) {
        System.out.printf("Mover disco %d desde %s hasta %s%n", n, sourceRod.getName(), destRod.getName());
    }
}
