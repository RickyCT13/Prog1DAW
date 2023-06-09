package actividades.ud7.practica7;


public class Student implements Comparable {
    private String name;
    private int participations;
    private Boolean canParticipate = true;

    public Student() {}

    public Student(String name, int participations) {
        this.name = name;
        this.participations = participations;
    }

    public String getName() {
        return name;
    }

    public int getParticipations() {
        return participations;
    }

    public Boolean getCanParticipate() {
        return canParticipate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }

    public void setCanParticipate(Boolean canParticipate) {
        this.canParticipate = canParticipate;
    }


    @Override
    public String toString() {
        return "\n" + "Alumno: " + name + "\n " +
                "Intervenciones: " + participations;
    }

    @Override
    public int compareTo(Object other) {
        Student otherStudent = (Student) other;
        if (this.getParticipations() < otherStudent.getParticipations()) {
            return -1;
        }
        else if (this.getParticipations() > otherStudent.getParticipations()) {
            return 1;
        }
        else {
            return (int) Math.round(Math.random());
        }
    }

    public static int compareName(Object o1, Object o2) {
        Student e1 = (Student) o1,
                e2 = (Student) o2;
        return e1.getName().compareTo(e2.getName());
    }
}
