package Actividades.UD7.SimulacroPractica7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class InterfazTexto {
    private static Scanner scanner;
    private List<Estudiante> listaEstudiantes;

    public void mainMenu() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        scanner = new Scanner(System.in);
        String inicio = "Escoja una opción introuduciendo su número correspondiente:" + "\n" +
                "1. Importar un fichero XML" + "\n" +
                "2. Exportar a un fichero XML" + "\n" +
                "3. Seleccionar un alumno aleatoriamente" + "\n" +
                "5. Mostrar participaciones de los estudiantes" + "\n" +
                "6. Salir" + "\n" +
                "->";
        System.out.print(inicio);
        int input = scanner.nextInt();
        while (input != 6) {
            opciones(input);
            System.out.print(inicio);
            input = scanner.nextInt();
        }
    }

    public void opciones(int input) throws IOException, ParserConfigurationException, SAXException, TransformerException {
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
                System.out.println(listaEstudiantes);
            case 6:
                break;
        }

    }

    public void importXML(String filePath) throws IOException, SAXException, ParserConfigurationException {
        // TODO: Implementar importación de XML para manejar los datos
        File file = new File(filePath);
        listaEstudiantes = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement();
        NodeList nList = doc.getElementsByTagName("alumno");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nodoEstudiante = nList.item(i);
            if (nodoEstudiante.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoEst = (Element) nodoEstudiante;
                String nombre = elementoEst.getElementsByTagName("nombre").item(0).getTextContent();
                int participaciones = Integer.parseInt(elementoEst.getElementsByTagName("intervenciones").item(0).getTextContent());
                listaEstudiantes.add(new Estudiante(nombre, participaciones));
            }
        }
        if (!listaEstudiantes.isEmpty()) {
            System.out.println("Documento importado con éxito.");
        }


    }

    public void exportXML(String filePath) throws ParserConfigurationException, TransformerException {
        // TODO: Exportar la información y reflejar los cambios realizados en un XML
        Document document = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder().newDocument();

        document.setXmlVersion("1.0");

        Element daw1 = document.createElement("daw1");
        document.appendChild(daw1);



    }

    public void selectStudent() {
        // TODO: seleccionar un alumno, teniendo en cuenta
        //  el número de participaciones y escoger aquellos con un nº
        //  menor. En caso de empate, seleccionar aleatoriamente.
        try {
            listaEstudiantes.sort(Estudiante::compareTo);
            ListIterator<Estudiante> lit = listaEstudiantes.listIterator();
            while (lit.hasNext()) {
                if (!lit.next().getCanParticipate()) {
                    continue;
                }
                System.out.print("El alumno seleccionado es: ");
                Estudiante candidato = lit.next();
                System.out.println(candidato.getNombre());
                System.out.println("¿Este estudiante puede participar? (S/N)");
                String respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Entendido. Se le dará un punto de participación al alumno seleccionado.");
                    candidato.setParticipaciones(candidato.getParticipaciones() + 1);
                    listaEstudiantes.sort(Estudiante::compareTo);
                    break;
                } else if (respuesta.equalsIgnoreCase("N")) {
                    System.out.println("Entendido. No se tendrá en cuenta este estudiante en la participación por el resto de la clase.");
                    candidato.setCanParticipate(false);
                    System.out.println("Seleccionando a otro alumno...");
                    listaEstudiantes.sort(Estudiante::compareTo);
                }
            }
        }
        catch (NoSuchElementException end) {
            System.out.println("No hay.");
        }
    }

    public void resetToZero() {
        // TODO: Reiniciar las participaciones de todos
        //  los alumnos a cero.
        for (Estudiante est : listaEstudiantes) {
            est.setParticipaciones(0);
        }
    }
}
