package by.epam.lab.dao.impl;

import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;
import by.epam.lab.handler.XMLHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ResultImplXml implements ResultDao {
    private Iterator<Result> iterator;

    public ResultImplXml(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler xmlHandler = new XMLHandler();
            parser.parse(fileName, xmlHandler);
            List<Result> resultList = xmlHandler.getResults();
            iterator = resultList.iterator();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.err.println(e);
        }
    }

    @Override
    public Result nextResult() {
        return iterator.next();
    }

    @Override
    public boolean hasResult() {
        return iterator.hasNext();
    }

    @Override
    public void close() {
    }
}
