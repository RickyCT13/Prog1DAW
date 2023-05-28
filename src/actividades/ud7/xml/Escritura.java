package actividades.ud7.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Escritura {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        // Creación de documento
        Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();

        // Creación del nodo raíz
        Element estudiantes = document.createElement("estudiantes");

        // Hacemos que cuelgue del doc.
        document.appendChild(estudiantes);

        // Creación del primer nodo
        Element estudianteFulanito = document.createElement("estudiante");
        estudiantes.appendChild(estudianteFulanito);

        // Nodo de texto (Valor del elto. anterior)
        Text fulanito = document.createTextNode("Fulanito Gómez");
        estudianteFulanito.appendChild(fulanito);

        Element estudianteMenganito = document.createElement("estudiante");
        estudiantes.appendChild(estudianteMenganito);
        Text menganito = document.createTextNode("Menganito Pérez");
        estudianteMenganito.appendChild(menganito);

        Element estudianteManolo = document.createElement("estudiante");
        estudiantes.appendChild(estudianteManolo);
        Text manolo = document.createTextNode("Manolo Cañas");
        estudianteManolo.appendChild(manolo);

        // finalizar creación XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("src/Actividades/UD7/XML/ejemplo.xml"));
        transformer.transform(source, result);
    }
}
