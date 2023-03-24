package Actividades.UD6.Act64;

import java.util.Arrays;

public class BackpackTest {
    public static void main(String[] args) {
        Double[] values = {20.0, 30.0, 66.0, 40.0, 60.0}, weights = {10.0, 20.0, 30.0, 40.0, 50.0};
        Double maxWeight = 100.0;
        FractionalBackpackProblem theft = new FractionalBackpackProblem(values, weights, maxWeight);
        theft.greedy();
        System.out.println(Arrays.toString(theft.solution));
    }
}
