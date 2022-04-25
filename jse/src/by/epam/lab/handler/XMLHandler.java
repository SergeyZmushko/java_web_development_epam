package by.epam.lab.handler;

import by.epam.lab.bean.TestXml;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import static by.epam.lab.util.Constants.*;

import java.util.LinkedList;

public class XMLHandler extends DefaultHandler {
    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, RESULT, TEST;
    }

    private final LinkedList<TestXml> results = new LinkedList<>();
    private ResultEnum currentEnum;
    private String currentLogin;

    public LinkedList<TestXml> getResults() {
        return results;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentEnum = ResultEnum.valueOf(qName.toUpperCase());
        if (currentEnum == ResultEnum.RESULT) {
            results.add(new TestXml(currentLogin, attributes.getValue(TEST_IND_XML),
                    attributes.getValue(DATE_IND_XML), attributes.getValue(MARK_IND_XML)));
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (currentEnum == ResultEnum.LOGIN) {
            String str = new String(ch, start, length).trim();
            if (!str.isEmpty()) {
                currentLogin = str;
            }
        }
    }
}

