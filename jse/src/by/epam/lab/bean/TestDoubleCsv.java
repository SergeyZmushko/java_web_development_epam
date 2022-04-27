package by.epam.lab.bean;

import java.sql.Date;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.Constants.REPLACEMENT;

public class TestDoubleCsv extends Test {

    public TestDoubleCsv(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public TestDoubleCsv(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    public String getStringMark() {
        return (getMark() / FORMAT_COEFFICIENT_10 + DOT + getMark() % FORMAT_COEFFICIENT_10).replaceAll(REPLACE_REGEX, REPLACEMENT);
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + getStringMark();
    }

}
