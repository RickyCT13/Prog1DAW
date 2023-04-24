package Actividades.UD6.Practica6.Ejercicio2;

public class MainEj2 {
    public static void main(String[] args) {
        Rod sourceRod = new Rod(), destRod = new Rod(), auxRod = new Rod();
        TowerOfHanoi.solve(3, sourceRod, destRod, auxRod);
        System.out.println(sourceRod);
        System.out.println(auxRod);
        System.out.println(destRod);
    }
}
