package actividades.ud3.practica3;

public class Alumno extends Persona {
    private Boolean esRepetidor;
    private Double notaMedia;
    private String email;

    private Direccion direccion;

    public Alumno() {
        throw new IllegalArgumentException("Debe especificar nombre, apellidos y edad.");
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, Integer edad) {
        super(nombre, primerApellido, segundoApellido, edad);
    }

    public Alumno(String nombre,
                  String primerApellido,
                  String segundoApellido,
                  Integer edad,
                  Boolean esRepetidor,
                  Double notaMedia,
                  String email) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.esRepetidor = esRepetidor;
        this.notaMedia = notaMedia;
        this.email = email;
    }

    public Alumno(String nombre,
                  String primerApellido,
                  String segundoApellido,
                  Integer edad,
                  Boolean esRepetidor,
                  Double notaMedia,
                  String email,
                  Direccion direccion) {
        super(nombre, primerApellido, segundoApellido, edad);
        this.esRepetidor = esRepetidor;
        this.notaMedia = notaMedia;
        this.email = email;
        this.direccion = direccion;
    }

    public Boolean getEsRepetidor() {
        return esRepetidor;
    }

    public void setEsRepetidor(Boolean esRepetidor) {
        this.esRepetidor = esRepetidor;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public static double mayorMedia(Alumno a1, Alumno a2) {
        return Math.max(a1.notaMedia, a2.notaMedia);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
