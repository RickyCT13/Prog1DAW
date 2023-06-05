package actividades.ud3.practica3;

public class Persona {
    private String
            nombre,
            primerApellido,
            segundoApellido;
    private Integer edad;

    public Persona() {
    }

    public Persona(String nombre, String primerApellido, String segundoApellido, Integer edad) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
        "\nPrimer apellido: " + primerApellido +
        "\nSegundo apellido: " + segundoApellido +
        "\nEdad: " + edad + " años.";
    }
}
