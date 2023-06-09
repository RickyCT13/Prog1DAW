package actividades.ud9.practica9;

import actividades.ud7.practica7.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class UserInterface {
    private static List<Student> studentList;
    public void start() {
        JFrame mainFrame = new JFrame("Interfaz Práctica");
        JPanel panel = new JPanel();
        JLabel welcomeOptions = new JLabel("Bienvenido al menú principal. Seleccione una de estas opciones para continuar:");
        JButton
                importButton = new JButton("Importar fichero XML"),
                exportButton = new JButton("Exportar a fichero XML"),
                selectButton = new JButton("Seleccionar a un alumno"),
                showStudentsButton = new JButton("Mostrar todos los estudiantes"),
                resetButton = new JButton("Reiniciar todas las participaciones a 0"),
                addButton = new JButton("Añadir un nuevo estudiante"),
                removeButton = new JButton("Eliminar un estudiante"),
                exitButton = new JButton("Salir del programa");
        exitButton.setForeground(Color.red);
        importButton.setSize(20, 20);
        panel.add(welcomeOptions);
        panel.add(importButton);
        panel.add(exportButton);
        panel.add(selectButton);
        panel.add(showStudentsButton);
        panel.add(resetButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(exitButton);

        /* ··· */
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String filePath = JOptionPane.showInputDialog("Introduzca la ruta del fichero XML a importar: ");
                try {
                    if (filePath != null) {
                        studentList = ManageXML.importXML(studentList, filePath);
                        JOptionPane.showMessageDialog(null, "Documento importado con éxito.",
                                "Importación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (NullPointerException | IOException | SAXException | ParserConfigurationException e) {
                    JOptionPane.showMessageDialog(null, "Error: Debe especificar una ruta válida.",
                            "Error de importación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String filePath = JOptionPane.showInputDialog("Introduzca la ruta y el nombre del fichero a exportar: ");
                try {
                    if (filePath != null) {
                        ManageXML.exportXML(studentList, filePath);
                        JOptionPane.showMessageDialog(null, "Documento exportado con éxito.",
                                "Exportación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch (ParserConfigurationException | TransformerException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageStudents.selectStudent(studentList);
            }
        });

        showStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (studentList != null) {
                    String[] columnNames = {"Nombre", "Participaciones"};
                    Object[][] studentData = new Object[studentList.size()][2];
                    for (int i = 1; i < studentList.size(); i++) {
                        studentData[i][0] = studentList.get(i).getName();
                        studentData[i][1] = studentList.get(i).getParticipations();
                    }
                    DefaultTableModel model = new DefaultTableModel(studentData, columnNames);

                    JTable table = new JTable(model);
                    table.setEnabled(false);

                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame("Estudiantes");
                    frame.add(scrollPane);
                    frame.pack();
                    frame.setVisible(true);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Sí", "No"};
                int confirmExit = JOptionPane.showOptionDialog(null,
                        "¿Está seguro de que quiere salir?", "Confirmación de Salida",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (confirmExit == JOptionPane.YES_OPTION) {
                    mainFrame.dispose();
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageStudents.resetToZero(studentList);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String input = JOptionPane.showInputDialog("Introduzca el nombre del nuevo estudiante: ");
                ManageStudents.addStudent(studentList, input);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageStudents.removeStudent(studentList);
            }
        });
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrame.dispose();
            }
        });
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(panel, BorderLayout.CENTER);
        mainFrame.setSize(600, 500);
        mainFrame.setVisible(true);

    }


}
