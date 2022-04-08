import by.epam.lab.bean.Result;
import by.epam.lab.service.XMLHandler;
import by.epam.lab.util.Constants;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();
            XMLHandler handler = new XMLHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(Constants.FILE_NAME);
            for (Result result : handler.getResults()) {
                System.out.println(result);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
