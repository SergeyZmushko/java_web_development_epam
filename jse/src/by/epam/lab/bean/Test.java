package by.epam.lab.bean;

import java.sql.Date;

import static by.epam.lab.util.Constants.*;

public class Test {
    private final String login;
    private final String test;
    private final Date date;
    private final int mark;

    public Test(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Test(String login, String test, String date, String mark) {
        this.login = login;
        this.test = test;
        this.date = Date.valueOf(date);
        this.mark = (int) (Double.parseDouble(mark) * FORMAT_COEFFICIENT);
    }

    private String getStringMark() {
        return (mark / FORMAT_COEFFICIENT + DOT + mark % FORMAT_COEFFICIENT).replaceAll(REPLACE_REGEX, REPLACEMENT);
    }

    public String getLogin() {
        return login;
    }

    public String getTest() {
        return test;
    }

    public Date getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public String toString() {
        return login + DELIMITER + test + DELIMITER + date + DELIMITER + getStringMark();
    }
}
