package Actividades.UD5.Practica5;

import Actividades.UD5.Practica5.MyQueue.MyQueue;
import Actividades.UD5.Practica5.MyStack.MyStack;


public class Main {
    public static void main(String[] args) {
        // Creamos una cola de Personas
        MyQueue personQueue = new MyQueue(new Person("Juan", 18), new Person("Carlos", 17), new Person("Manuel", 21), new Person("María", 20));
        System.out.println(personQueue);

        // La primera persona que entró a la cola se va, en este caso, Juan.
        personQueue.deQueue();
        System.out.println(personQueue);

        // Llega otra persona, Alberto, y se pone a la cola.
        personQueue.queue(new Person("Alberto", 25));
        System.out.println(personQueue);

        // Queremos saber el primero de la cola y el resto respectivamente
        System.out.println(personQueue.firstInQueue());
        System.out.println(personQueue.allButFirst());

        // Vemos que la cola no está vacía, obtenemos su tamaño.
        System.out.println(personQueue.isEmpty());
        System.out.println(personQueue.getSize());

        // Se vacía la cola. No hay nadie más.
        personQueue.clearQueue();
        System.out.println(personQueue.isEmpty());

        // Creemos ahora una pila de libros
        MyStack bookStack = new MyStack(new Book("1984", "George Orwell", 12.50), new Book("Inferno", "Dan Brown", 15.00), new Book("Java for dummies", "John Doe", 18.00));

        System.out.println(bookStack);

        // El último libro en la pila
        System.out.println(bookStack.top());
        // Es "Java for dummies"

        // Añadimos un nuevo libro a la pila
        bookStack.stack(new Book("Structured Query Language Guide", "John Doe", 12.35));
        // Ahora, el libro en la cima será el que hemos añadido
        System.out.println(bookStack.top());

        // Para quitar "Java for dummies", tenemos que quitarle de encima otros libros primero, en este caso 1.
        bookStack.deStack();
        System.out.println(bookStack);

        // Quitamos el libro de Java de la pila.
        bookStack.deStack();
        System.out.println(bookStack);

        // La pila no está vacía, por lo que devolverá false.
        System.out.println(bookStack.isEmpty());

        // Comprobamos que el tamaño es 2
        System.out.println(bookStack.getSize());

        // Vaciamos la pila
        bookStack.clearStack();
        System.out.println(bookStack.isEmpty());

    }
}
