package Actividades.UD7.SimulacroPractica7;


public class Estudiante implements Comparable {
    private String nombre;
    private int participaciones;
    private boolean canParticipate = true;

    public Estudiante() {}

    public Estudiante(String nombre, int participaciones) {
        this.nombre = nombre;
        this.participaciones = participaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getParticipaciones() {
        return participaciones;
    }

    public boolean getCanParticipate() {
        return canParticipate;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setParticipaciones(int participaciones) {
        this.participaciones = participaciones;
    }

    public void setCanParticipate(boolean canParticipate) {
        this.canParticipate = canParticipate;
    }


    @Override
    public String toString() {
        return "\n" + "Alumno: " + nombre + "\n" +
                "Intervenciones: " + participaciones;
    }

    @Override
    public int compareTo(Object other) {
        Estudiante otherEstudiante = (Estudiante) other;
        if (this.getParticipaciones() < otherEstudiante.getParticipaciones()) {
            return -1;
        }
        else if (this.getParticipaciones() > otherEstudiante.getParticipaciones()) {
            return 1;
        }
        else {
            return (int) Math.round(Math.random());
        }
    }
}