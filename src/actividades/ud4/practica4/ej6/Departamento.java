package actividades.ud4.practica4.ej6;

import java.util.List;
import java.util.Objects;

public class Departamento {
    private String nombre;

    private List<Empleado> empleados;

    public Departamento() {}

    public Departamento(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void adicionEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void eliminarEmpleado(String codEmpleado) {
        empleados.removeIf(e -> Objects.equals(e.getCodEmpleado(), codEmpleado));
    }
}
