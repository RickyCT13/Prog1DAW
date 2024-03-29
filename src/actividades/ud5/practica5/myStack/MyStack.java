package actividades.ud5.practica5.myStack;

import java.util.LinkedList;
import java.util.List;

public class MyStack {

    private List values = new LinkedList();
    public MyStack() {}

    /**
     *
     * Adición de un método constructor opcional para poder añadir elementos a la pila sin tener que hacerlo uno por uno.
     */
    public MyStack(Object... elements) {
        for (Object element : elements) {
            stack(element);
        }
    }

    /**
     *
     * @param element El elemento a añadir a la pila.
     */
    public void stack(Object element) {
        values.add(element);
    }

    /**
     * Saca el último elemento añadido de la pila, obedeciendo el método LIFO (Last In First Out).
     */
    public void deStack() {
        values.remove(values.size() - 1);
    }

    /**
     *
     * @return El último elemento añadido a la pila.
     */
    public Object top() {
        return values.get(values.size() - 1);
    }

    /**
     * Vacía la pila.
     */
    public void clearStack() {
        values.clear();
    }

    /**
     *
     * @return Si la pila está vacia o no.
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     *
     * @return el número de elementos de la pila.
     */
    public int getSize() {
        return values.size();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "values=" + values +
                '}';
    }
}
