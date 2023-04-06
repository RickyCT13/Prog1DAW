package Actividades.UD6.Act65;

import java.util.Objects;
import java.util.Vector;

public class BinarySearchWithDaC extends DivideAndConquer {
    Vector<Integer> numbers = new Vector<>();
    int pos = (int) numbers.size() / 2;
    Integer element;

    public BinarySearchWithDaC(Vector<Integer> numbers, Integer element) {
        this.numbers.addAll(numbers);
        this.element = element;
    }


    @Override
    protected boolean isBaseCase(Object problem) {
        return numbers.size() == 1;
    }

    @Override
    protected Object solveBaseCase(Object problem) {
        if (Objects.equals(numbers.get(pos), element)) {

        }
        return null;
    }

    @Override
    protected Object[] divide(Object problem) {
        return new Object[0];
    }

    @Override
    protected Object combine(Object[] subsolutions) {
        return null;
    }
}
