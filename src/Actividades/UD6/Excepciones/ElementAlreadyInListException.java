package Actividades.UD6.Excepciones;

public class ElementAlreadyInListException extends IllegalArgumentException {
    ElementAlreadyInListException(String message) {
        super(message);
    }
}
