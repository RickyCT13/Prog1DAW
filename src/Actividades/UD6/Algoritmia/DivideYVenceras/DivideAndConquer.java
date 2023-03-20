package Actividades.UD6.Algoritmia.DivideYVenceras;

public abstract class DivideAndConquer {
    int[] problem;
    int solution;
    int[][] subproblems;
    int[][] subsolutions;
    int i, size;

    public void divAndCon() {
        if (baseCase()) {
            solution = solveBaseCase(problem);
        }
        else {
            // subproblems = divide(problem);
            size = subproblems.length;
            subsolutions = new int[size][];
            for (i = 1; i <= size; i++) {
                subsolutions[i] = subproblems[i];
            }
            // solution = combine(subsolutions);
        }
    }

    protected abstract boolean baseCase();

    protected abstract int solveBaseCase(int[] problem);

    protected abstract int combine(int[] subsolutions);
    protected abstract int[] divide(int[] problem);
}
