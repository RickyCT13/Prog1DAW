package actividades.ud4.practica4.ej6;

import java.util.List;

public class Sede {
    private String ciudad;
    private List<Departamento> departamentos;

    public Sede() {}

    public Sede(String ciudad, List<Departamento> departamentos) {
        this.ciudad = ciudad;
        this.departamentos = departamentos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
