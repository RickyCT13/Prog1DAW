package actividades.ud5.practica5.myQueue;

import java.util.LinkedList;
import java.util.List;

public class MyQueue {

    private List values = new LinkedList();
    public MyQueue() {}

    /**
     * Con este método constructor podemos inicializar la cola sin tener que añadir los valores de uno en uno.
     */
    public MyQueue(Object... elements) {
        for (Object element : elements) {
            queue(element);
        }
    }

    /**
     * @param element el elemento cuya posición será la última.
     */
    public void queue(Object element) {
        values.add(element);
    }

    /**
     * Saca el primer elemento que entró en la cola.
     * Junto con queue, obedece el método FIFO (First in First Out).
     */
    public void deQueue() {
        values.remove(0);
    }

    /**
     * @return El primer elemento en la cola
     */
    public Object firstInQueue() {
        return values.get(0);
    }

    /**
     * @return Una sublista consistente de los elementos empezando desde el segundo y terminando en el último.
     */
    public List<Object> allButFirst() {
        return values.subList(1, values.size() - 1);
    }

    /**
     * Limpia la cola, simplemente realizando el método clear() en la ArrayList.
     */
    public void clearQueue() {
        values.clear();
    }

    /**
     * @return El resultado del método isEmpty() de la lista, true o false.
     */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    /**
     * @return La longitud de la cola.
     */
    public int getSize() {
        return values.size();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "values=" + values +
                '}';
    }
}
