package by.epam.lab.strategy;

import by.epam.lab.bean.Test;
import by.epam.lab.bean.TestXml;
import by.epam.lab.handler.XMLHandler;
import org.xml.sax.SAXException;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class XmlDb extends Config {

    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            parser.parse(filename, xmlHandler);
            db.clearTables();
            List<TestXml> tests = xmlHandler.getResults();
            for (Test test : tests) {
                db.insertStudent(test);
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println(e);
        }
    }

    public LinkedList<TestXml> currentMonthResults() throws SQLException, ClassNotFoundException {
        LinkedList<TestXml> sortedDateList = new LinkedList<>();
        ResultSet resultSet = db.getSortedDateListRequest();
        while (resultSet.next()) {
            sortedDateList.add(new TestXml(resultSet.getString(LOGIN_IND_DB),
                    resultSet.getString(TEST_IND_DB),
                    resultSet.getDate(DATE_IND_DB),
                    resultSet.getInt(MARK_IND_DB)));
        }
        if (sortedDateList.isEmpty()) {
            System.out.println(NO_DATA);
        }
        return sortedDateList;
    }
}
