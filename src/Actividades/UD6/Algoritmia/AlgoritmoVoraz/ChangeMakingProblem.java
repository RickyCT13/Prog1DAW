package Actividades.UD6.Algoritmia.AlgoritmoVoraz;

public class ChangeMakingProblem extends GreedyStrategy {

    // Input
    int[] coins;
    int change;

    // Atributos internos del algoritmo
    int[] solution;
    int candidate;
    int stage;

    public ChangeMakingProblem(int[] coins, int change) {
        this.coins = coins;
        this.change = change;
    }

    @Override
    protected void initialize() {
        solution = new int[coins.length];
        candidate = 0;
        stage = 0;
    }

    @Override
    protected boolean end() {
        return stage == coins.length;
    }

    @Override
    protected void selectAndRemoveCandidate() {
        candidate = change / coins[stage];
    }

    @Override
    protected boolean isPromising() {
        return true;
    }

    @Override
    protected void noteDownInSolution() {
        solution[stage] = candidate;
        change = change - coins[stage] * candidate;
        stage++;
    }
}
