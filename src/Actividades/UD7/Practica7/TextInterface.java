package Actividades.UD7.Practica7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TextInterface {
    private static Scanner scanner;
    private List<Student> studentList;

    public void mainMenu() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        scanner = new Scanner(System.in);
        String start = "Escoja una opción introuduciendo su número correspondiente:" + "\n" +
                "1. Importar un fichero XML" + "\n" +
                "2. Exportar a un fichero XML" + "\n" +
                "3. Seleccionar un alumno aleatoriamente" + "\n" +
                "4. Reiniciar todas las participaciones a 0" + "\n" +
                "5. Mostrar participaciones de los estudiantes" + "\n" +
                "6. Salir" + "\n" +
                "->";
        System.out.print(start);
        int input = scanner.nextInt();
        while (input != 6) {
            options(input);
            System.out.print(start);
            input = scanner.nextInt();
        }
    }

    public void options(int input) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        switch(input) {
            case 1:
                System.out.println("Introduzca la ruta al fichero: ");
                String path = scanner.next();
                importXML(path);
                break;
            case 2:
                System.out.print("Indique la ruta del nuevo fichero: ");
                String path1 = scanner.next();
                exportXML(path1);
                break;
            case 3:
                selectStudent();
                break;
            case 4:
                resetToZero();
                System.out.println("Todas las participaciones han sido reiniciadas a 0.");
                break;
            case 5:
                System.out.println(studentList);
            case 6:
                break;
        }

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
            System.out.println("Documento importado con éxito.");
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

        System.out.println("Exportación exitosa!");
    }

    public void selectStudent() {
        // TODO: seleccionar un alumno, teniendo en cuenta
        //  el número de participaciones y escoger aquellos con un nº
        //  menor. En caso de empate, seleccionar aleatoriamente.
        try {
            studentList.sort(Student::compareTo);
            ListIterator<Student> lit = studentList.listIterator();
            while (lit.hasNext()) {
                if (!lit.next().getCanParticipate()) {
                    continue;
                }
                System.out.print("El alumno seleccionado es: ");
                Student candidate = lit.next();
                System.out.println(candidate.getName());
                System.out.println("¿Este estudiante puede participar? (S/N)");
                String reply = scanner.next();
                if (reply.equalsIgnoreCase("S")) {
                    System.out.println("Entendido. Se le dará un punto de participación al alumno seleccionado.");
                    candidate.setParticipations(candidate.getParticipations() + 1);
                    studentList.sort(Student::compareTo);
                    break;
                } else if (reply.equalsIgnoreCase("N")) {
                    System.out.println("Entendido. No se tendrá en cuenta este estudiante en la participación por el resto de la clase.");
                    candidate.setCanParticipate(false);
                    System.out.println("Seleccionando a otro alumno...");
                    studentList.sort(Student::compareTo);
                }
            }
        }
        catch (NoSuchElementException end) {
            System.out.println("¡No hay estudiantes que puedan participar!");
        }
    }

    public void resetToZero() {
        // TODO: Reiniciar las participaciones de todos
        //  los alumnos a cero.
        for (Student est : studentList) {
            est.setParticipations(0);
        }
    }
}
