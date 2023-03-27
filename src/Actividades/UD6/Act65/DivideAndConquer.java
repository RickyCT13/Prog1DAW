package Actividades.UD6.Act65;

public abstract class DivideAndConquer {
    Object solution;
    public Object dac(Object problem) {
        Object[] subproblems, subsolutions;
        Integer size, i;
        if (isBaseCase(problem)) {
            solution = solveBaseCase(problem);
        }
        else {
            subproblems = divide(problem);
            size = subproblems.length;
            subsolutions = new Object[size];
            for (i = 0; i < size; i++) {
                subsolutions[i] = dac(subproblems[i]);
            }
            solution = combine(subsolutions);
        }
        return solution;
    }

    protected abstract boolean isBaseCase(Object problem);

    protected abstract Object solveBaseCase(Object problem);

    protected abstract Object[] divide(Object problem);

    protected abstract Object combine(Object[] subsolutions);

}
