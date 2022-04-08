package by.epam.lab.service;

import by.epam.lab.bean.Date;
import by.epam.lab.bean.Result;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static by.epam.lab.util.Constants.*;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {
    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private final List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String currentLogin;

    public List<Result> getResults() {
        return results;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(qName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            Result result = new Result(currentLogin,
                    attributes.getValue(NAME_TAG),
                    attributes.getValue(DATE_TAG),
                    attributes.getValue(MARK_TAG));
            results.add(result);
        }
        if (currentEnum == ResultEnum.STUDENT) {
            currentLogin = null;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (currentEnum == ResultEnum.LOGIN) {
            if (currentLogin == null) {
                currentLogin = new String(ch, start, length);
            }
        }
    }
}
