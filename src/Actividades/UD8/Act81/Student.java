package Actividades.UD8.Act81;

import javax.persistence.*;

@Entity(name = "estudiante")
public class Student extends Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int participations;
    private String group;
    private Computer computer;

    public Student() {}

    public Student (String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    public Student (String name, int age, String group, Computer computer) {
        super(name, age);
        this.group = group;
        this.computer = computer;
    }

    public String getGroup() {
        return group;
    }

    public Computer getComputer() {
        return computer;
    }

    public int getParticipations() {
        return participations;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void setParticipations(int participations) {
        this.participations = participations;
    }
}
