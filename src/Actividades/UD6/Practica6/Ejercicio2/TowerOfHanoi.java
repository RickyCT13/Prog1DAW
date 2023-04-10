package Actividades.UD6.Practica6.Ejercicio2;

public class TowerOfHanoi {
    Rod sourceRod, destRod, auxRod;
    public TowerOfHanoi(Integer n) {
        sourceRod = new Rod();
        destRod = new Rod();
        auxRod = new Rod();
        for (int i = n; i >= 1; i--) {
            sourceRod.push(i);
        }
    }
    public void hanoi(Integer n, Rod sourceRod, Rod destRod, Rod auxRod) {
        if (n == 1) {
            moveDisk(n, sourceRod, destRod);
            printMove
            return;
        }
    }
    public void printMove(Integer n, Rod from, Rod to) {
        System.out.println("Mover el disco " + n + " desde " + from.name + " hasta " + to.name);
    }

    public void moveDisk(Integer n, Rod from, Rod to) {
        if (to.peek() > n || to.isEmpty()) {
            to.push(from.pop());
            printMove(n, from, to);
        }
    }
}
