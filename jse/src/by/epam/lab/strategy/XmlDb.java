package by.epam.lab.strategy;

import by.epam.lab.bean.Test;
import by.epam.lab.handler.XMLHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class XmlDb extends Config {

    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            parser.parse(filename, xmlHandler);
            List<Test> tests = xmlHandler.getResults();
            //.................add to db

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println(e);
        }
    }
}
