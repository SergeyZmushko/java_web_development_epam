import by.epam.lab.bean.Result;
import by.epam.lab.service.XMLHandler;
import by.epam.lab.util.Constants;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            parser.parse(Constants.FILE_NAME, xmlHandler);
            for (Result result : xmlHandler.getResults()) {
                System.out.println(result);
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println(e);
        }
    }
}
