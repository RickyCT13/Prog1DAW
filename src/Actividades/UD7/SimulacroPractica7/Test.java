package Actividades.UD7.SimulacroPractica7;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        InterfazTexto test = new InterfazTexto();
        test.mainMenu();
    }
}
