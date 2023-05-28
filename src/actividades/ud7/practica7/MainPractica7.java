package actividades.ud7.practica7;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class MainPractica7 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        TextInterface test = new TextInterface();
        test.mainMenu();
    }
}
