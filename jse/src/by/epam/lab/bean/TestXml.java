package by.epam.lab.bean;


import static by.epam.lab.util.Constants.*;

import java.sql.Date;

public class TestXml extends Test {

    public TestXml(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public TestXml(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    public String getStringMark() {
        return String.format(FORMAT_MARK_XML, getMark() / FORMAT_COEFFICIENT_10, getMark() % FORMAT_COEFFICIENT_10);
    }

    protected String fieldToString() {
        return super.fieldToString() + getStringMark();
    }
}
