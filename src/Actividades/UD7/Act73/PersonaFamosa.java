package Actividades.UD7.Act73;

public class PersonaFamosa extends Persona {
    /* Decidí crear una subclase para indicar si la persona famosa en cuestión está viva actualmente. */
    private Boolean estaViva;

    public PersonaFamosa(String nombre, Integer edad, Persona padre, Direccion direccion, Boolean estaViva) {
        super(nombre, edad, padre, direccion);
        this.estaViva = estaViva;
    }
}
