package actividades.ud9.practica9;

import actividades.ud7.practica7.Student;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ManageStudents {
    public static void selectStudent(List<Student> studentList) {
        // TODO: seleccionar un alumno, teniendo en cuenta
        //  el número de participaciones y escoger aquellos con un nº
        //  menor. En caso de empate, seleccionar aleatoriamente.
        Student candidate;
        studentList.sort(Student::compareTo);
        Iterator<Student> it = studentList.listIterator();
        label:
        while (it.hasNext()) {
            if (!it.next().getCanParticipate()) {
                continue;
            }
            else candidate = it.next();
            String[] options = {"Sí", "No"};
            int input = JOptionPane.showOptionDialog(null,
                    "El alumno seleccionado es: " + candidate.getName() + "\n" +
                            "¿Este estudiante puede participar?", "Selección de estudiante",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

            switch (input) {
                case JOptionPane.YES_OPTION:
                    candidate.setParticipations(candidate.getParticipations() + 1);
                    JOptionPane.showMessageDialog(null,
                            "Se ha asignado una participación al estudiante indicado.",
                            "Selección de estudiante", JOptionPane.INFORMATION_MESSAGE);
                    break label;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null,
                            "No se tendrá en cuenta al alumno por el resto de la clase.",
                            "Selección de estudiante", JOptionPane.INFORMATION_MESSAGE);
                    candidate.setCanParticipate(false);
                    it.remove();
                    input = JOptionPane.showOptionDialog(null,
                            "¿Quiere seleccionar a otro alumno?", "Selección de estudiante",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                    if (input == JOptionPane.YES_OPTION) {
                        selectStudent(studentList);
                    }
                    break label;
                default:
                    break label;
            }
        }
    }

    public static void addStudent(List<Student> studentList, String name) {
        studentList.add(new Student(name, 0));
        JOptionPane.showMessageDialog(null, "Se ha añadido al estudiante con éxito.",
                "Añadir estudiante", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void removeStudent(List<Student> studentList) {
        String[] options = {"Eliminar un estudiante por nombre", "Eliminar al estudiante MENOS participativo"};
        int input = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Eliminar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        switch (input) {
            case JOptionPane.YES_OPTION:
                String name = JOptionPane.showInputDialog( "Introduzca el nombre del estudiante:");
                studentList.removeIf(s -> Objects.equals(s.getName(), name));
                JOptionPane.showMessageDialog(null, "Se ha eliminado al estudiante.",
                        "Eliminar estudiante", JOptionPane.INFORMATION_MESSAGE);
                break;
            case JOptionPane.NO_OPTION:
                studentList.sort(Student::compareTo);
                String result = studentList.get(0).getName();
                studentList.remove(0);
                JOptionPane.showMessageDialog(null, "Se ha eliminado al siguiente estudiante: "
                        + result + ".", "Eliminar estudiante", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public static void resetToZero(List<Student> studentList) {
        // TODO: Reiniciar las participaciones de todos
        //  los alumnos a cero.
        for (Student est : studentList) {
            est.setParticipations(0);
        }
        JOptionPane.showMessageDialog(null,
                "Se han reiniciado todas las participaciones a 0.",
                "Reinicio de participaciones", JOptionPane.INFORMATION_MESSAGE);
    }
}
