package by.epam.lab.bean;

import by.epam.lab.util.Constants;

import java.sql.Date;

public class TestIntCsv extends Test {

    public TestIntCsv(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public TestIntCsv(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    private String getStringMark() {
        return String.valueOf(getMark() / Constants.FORMAT_COEFFICIENT_10);
    }

    @Override
    public String fieldToString() {
        return super.fieldToString() + getStringMark();
    }
}
