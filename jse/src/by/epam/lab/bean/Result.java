package by.epam.lab.bean;

import java.sql.Date;

import static by.epam.lab.util.Constants.*;

public class Result {
    private final String login;
    private final String test;
    private final Date date;
    private final int mark;

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String test, String date, String mark) {
        this(login, test, Date.valueOf(date), Integer.parseInt(mark));
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

    public String getLogin() {
        return login;
    }

    public String markToString() {
        return String.valueOf(mark);
    }

    public String toString() {
        return getClass().getSimpleName() + DELIMITER + login + DELIMITER + test + DELIMITER + date + DELIMITER + markToString();
    }
}
