package actividades.ud6.algoritmia.algoritmoVoraz;

import java.util.Arrays;

public class ChangeTest {
    public static void main(String[] args) {
        int[] coins = {17, 10, 5, 3, 2};
        int change = 31;
        ChangeMakingProblem cmp = new ChangeMakingProblem(coins, change);
        cmp.greedy();
        System.out.println(Arrays.toString(cmp.solution));
    }
}
