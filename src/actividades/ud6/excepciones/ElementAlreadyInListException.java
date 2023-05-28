package actividades.ud6.excepciones;

public class ElementAlreadyInListException extends IllegalArgumentException {
    ElementAlreadyInListException(String message) {
        super(message);
    }
}
