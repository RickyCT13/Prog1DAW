package Actividades.UD7.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Lectura {
    public static void main(String[] args) {
        File file = new File("src/Actividades/UD7/XML/ejemplo.xml");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            System.out.println("Tipo de node: " + document.getDocumentElement().getNodeType());

            NodeList estudiantes = document.getElementsByTagName("estudiante");

            for (int i = 0; i < estudiantes.getLength(); i++) {
                Node nodeEstudiante = estudiantes.item(i);
                if (nodeEstudiante.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementEstudiante = (Element) nodeEstudiante;
                    System.out.println("Nombre del estudiante: " + elementEstudiante.getTextContent());
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
