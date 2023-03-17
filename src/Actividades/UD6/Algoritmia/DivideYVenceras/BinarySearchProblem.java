package Actividades.UD6.Algoritmia.DivideYVenceras;

public class BinarySearchProblem extends DivideAndConquer {
    int element;
    int pos = problem.length / 2;
    @Override
    protected boolean baseCase() {
        return problem[pos] == element;
    }

    @Override
    protected int solveBaseCase(int[] problem) {
        return problem[pos];
    }

    @Override
    protected int combine(int[] subsolutions) {
        return solution;
    }

    @Override
    protected int[] divide(int[] problem) {
        int[] problemDivided = new int[pos];
        switch (Integer.compare(problem[pos],element)) {
            case 1:
                System.arraycopy(problem, 0, problemDivided, 0, pos);
                break;
            case -1:
                System.arraycopy(problem, pos, problemDivided, 0, pos);
                break;
        }
        return problemDivided;
    }
}
