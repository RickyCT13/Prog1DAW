package actividades.ud9.practica9;

import actividades.ud7.practica7.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.swing.*;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserInterface {
    private List<Student> studentList;
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
                exitButton = new JButton("Salir del programa");
        exitButton.setForeground(Color.red);
        panel.add(welcomeOptions);
        panel.add(importButton);
        panel.add(exportButton);
        panel.add(selectButton);
        panel.add(showStudentsButton);
        panel.add(resetButton);
        panel.add(exitButton);

        /* ··· */
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String filePath = JOptionPane.showInputDialog("Introduzca la ruta del fichero XML a importar: ");
                try {
                    if (filePath != null) {
                        importXML(filePath);
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
                        exportXML(filePath);
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
                selectStudent();
            }
        });

        showStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (studentList != null) {
                    JList studentJList = new JList<>(studentList.toArray());
                    JFrame studentListFrame = new JFrame("Lista de estudiantes.");
                    JPanel studentListPanel = new JPanel();
                    studentListPanel.add(studentJList);
                    studentListFrame.add(studentListPanel);
                    studentListFrame.pack();
                    studentListPanel.setVisible(true);
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
    public void importXML(String filePath) throws IOException, SAXException, ParserConfigurationException {
        // TODO: Implementar importación de XML para manejar los datos
        File file = new File(filePath);
        studentList = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement();
        NodeList nList = doc.getElementsByTagName("alumno");
        for (int i = 0; i < nList.getLength(); i++) {
            Node studentNode = nList.item(i);
            if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element stElement = (Element) studentNode;
                String name = stElement.getElementsByTagName("nombre").item(0).getTextContent();
                int participations = Integer.parseInt(stElement.getElementsByTagName("intervenciones").item(0).getTextContent());
                studentList.add(new Student(name, participations));
            }
        }
        if (!studentList.isEmpty()) {
            System.out.println("Documento importado con éxito." + "\n");
        }


    }

    public void exportXML(String filePath) throws ParserConfigurationException, TransformerException {
        // TODO: Exportar la información y reflejar los cambios realizados en un XML
        Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();

        document.setXmlVersion("1.0");

        studentList.sort(Student::compareName);
        Element daw1 = document.createElement("daw1");
        document.appendChild(daw1);

        for (Student est:
                studentList) {

            Element alumno = document.createElement("alumno");
            daw1.appendChild(alumno);

            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode(est.getName()));
            daw1.appendChild(nombre);

            Element intervenciones = document.createElement("intervenciones");
            intervenciones.appendChild(document.createTextNode(String.valueOf(est.getParticipations())));
            daw1.appendChild(intervenciones);
        }

        DOMSource domSource = new DOMSource(document);

        StreamResult result = new StreamResult(new File(filePath));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(domSource, result);

        System.out.println("Exportación exitosa." + "\n");
    }
    public void selectStudent() {
        // TODO: seleccionar un alumno, teniendo en cuenta
        //  el número de participaciones y escoger aquellos con un nº
        //  menor. En caso de empate, seleccionar aleatoriamente.
        try {
            studentList.sort(Student::compareTo);
            Iterator<Student> it = studentList.iterator();
            while (it.hasNext()) {
                if (!it.next().getCanParticipate()) {
                    continue;
                }
                Student candidate = it.next();
                String[] options = {"Sí", "No"};
                int input = JOptionPane.showOptionDialog(null,
                        "El alumno seleccionado es: " + candidate.getName() + "\n" +
                                "¿Este estudiante puede participar?", "Selección de estudiante",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (input == JOptionPane.YES_OPTION) {
                    candidate.setParticipations(candidate.getParticipations() + 1);
                    JOptionPane.showMessageDialog(null,
                            "Se ha asignado una participación al estudiante indicado.",
                            "Selección de estudiante", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else if (input == JOptionPane.NO_OPTION) {
                    candidate.setCanParticipate(false);
                    JOptionPane.showMessageDialog(null,
                            "No se tendrá en cuenta al alumno por el resto de la clase.",
                            "Selección de estudiante", JOptionPane.INFORMATION_MESSAGE);
                    selectStudent();
                }
            }
        }
        catch (NoSuchElementException end) {
            JOptionPane.showMessageDialog(null,
                    "Ya no quedan estudiantes para participar",
                    "Selección de estudiante", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void resetToZero() {
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
