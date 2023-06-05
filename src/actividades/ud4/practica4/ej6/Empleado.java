package actividades.ud4.practica4.ej6;

public class Empleado {
    private String codEmpleado, DNI, nombre, primerApellido, segundoApellido;
    private int annoNacimiento;
    private Boolean jornadaReducida;

    public Empleado() {}

    public Empleado(String codEmpleado, String DNI, String nombre, String primerApellido, String segundoApellido, int annoNacimiento, Boolean jornadaReducida) {
        this.codEmpleado = codEmpleado;
        this.DNI = DNI;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.annoNacimiento = annoNacimiento;
        this.jornadaReducida = jornadaReducida;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
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

    public int getAnnoNacimiento() {
        return annoNacimiento;
    }

    public void setAnnoNacimiento(int annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public Boolean getJornadaReducida() {
        return jornadaReducida;
    }

    public void setJornadaReducida(Boolean jornadaReducida) {
        this.jornadaReducida = jornadaReducida;
    }

    @Override
    public String toString() {
        return "Empleado {" + '\n' +
                "codEmpleado: " + codEmpleado + '\n' +
                ", DNI: " + DNI + '\n' +
                ", nombre: " + nombre + '\n' +
                ", primerApellido: " + primerApellido + '\n' +
                ", segundoApellido: " + segundoApellido + '\n' +
                ", annoNacimiento: " + annoNacimiento + '\n' +
                ", jornadaReducida: " + jornadaReducida + '\n' +
                '}';
    }
}
