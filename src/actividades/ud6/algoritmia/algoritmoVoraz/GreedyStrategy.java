package actividades.ud6.algoritmia.algoritmoVoraz;

/*
* Un algoritmo voraz 'Greedy algorithm' intenta solcionar los problemas
* seleccionando la mejor opción en el momento.
*/

public abstract class GreedyStrategy {
    public void greedy() {
        initialize();
        while(!end()) {
            selectAndRemoveCandidate();
            if(isPromising()) {
                noteDownInSolution();
            }
        }
    }

    protected abstract void initialize();

    protected abstract boolean end();

    protected abstract void selectAndRemoveCandidate();

    protected abstract boolean isPromising();

    protected abstract void noteDownInSolution();
}
