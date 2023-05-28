package actividades.ud6.act64;

import java.util.Arrays;

public class FractionalBackpackProblem extends GreedyStrategy {
    private Double[] values;
    private Double[] weights;
    private Integer size;
    private Double maxWeight, curWeight;
    public FractionalBackpackProblem(Double[] values, Double[] weights, Double maxWeight) {
        if (values.length == weights.length) {
            this.values = values;
            this.weights = weights;
            this.maxWeight = maxWeight;
            size = values.length;
         }
    }

    @Override
    protected void initialize() {
        curWeight = 0d;
        solution = new Double[size];
        Arrays.fill(solution, 0d);
        candidate = 0d;
    }

    @Override
    protected boolean end() {
        return curWeight >= maxWeight;
    }

    @Override
    protected void selectAndRemoveCandidate() {
        stage = 0;
        Double bestRatio = values[0]/weights[0];
        for (int i = 0; i < size; i++) {
            if (bestRatio < values[i]/weights[i]) {
                bestRatio = values[i]/weights[i];
                stage = i;
            }
        }
        values[stage] = 0d;
    }

    @Override
    protected boolean isPromising() {
        return true;
    }

    @Override
    protected void noteDownInSolution() {
        if(curWeight + weights[stage] <= maxWeight) {
            candidate = 1d;
        }
        else {
            candidate = (maxWeight - curWeight) / weights[stage];
        }
        solution[stage] = candidate;
        curWeight += (Double) candidate * weights[stage];
    }
}
