package actividades.ud9.practica9;

import actividades.ud7.practica7.Student;
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
import java.util.LinkedList;
import java.util.List;

public class ManageXML {
    public static List<Student> importXML(List<Student> studentList, String filePath) throws IOException, SAXException, ParserConfigurationException {
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
        return studentList;
    }

    public static void exportXML(List<Student> studentList, String filePath) throws ParserConfigurationException, TransformerException {
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

        System.out.println("Exportación exitosa.\n");
    }
}
