package actividades.ud7.act74;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new LinkedList<>();

        contactList.add(new Contact("Juan", "Av. de la Feria 1X", 647647647));
        contactList.add(new Contact("Menganito", "Calle Palacios 23Y", 644764447));
        contactList.add(new Contact("Fulanito", "Calle Higos 32X", 641812432));

        try {
            Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();
            document.setXmlVersion("1.0");
            Element listaContactos = document.createElement("listaContactos");
            document.appendChild(listaContactos);

            for (Contact c:
                 contactList) {

                Element contacto = document.createElement("contacto");
                listaContactos.appendChild(contacto);

                Element nombre = document.createElement("nombre");
                nombre.appendChild(document.createTextNode(c.getName()));
                listaContactos.appendChild(nombre);

                Element direccion = document.createElement("nombre");
                direccion.appendChild(document.createTextNode(c.getAddress()));
                listaContactos.appendChild(direccion);

                Element numero = document.createElement("numero");
                numero.appendChild(document.createTextNode(String.valueOf(c.getPhoneNumber())));
                listaContactos.appendChild(numero);

            }

            DOMSource domSource = new DOMSource(document);

            StreamResult result = new StreamResult(new File("src/actividades/ud7/act74/listacontactos.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(domSource, result);

            System.out.println("Exportación exitosa." + "\n");

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
