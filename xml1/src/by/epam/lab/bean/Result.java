package by.epam.lab.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import static by.epam.lab.util.Constants.*;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat(OUTPUT_DATE);

    public Result(String login, String test, String date, String mark) {
        this.login = login;
        this.test = test;
        this.date = java.sql.Date.valueOf(date);
        this.mark = (int) (Double.parseDouble(mark) * TEN);
    }

    private String getStringDate() {
        return OUTPUT_DATE_FORMAT.format(date);
    }

    private String getStringMark() {
        return (mark / TEN) + DOT + (mark % TEN);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public void setMark(int mark) {
        this.mark = mark;
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
        return login + DELIMITER + test + DELIMITER + getStringDate() + DELIMITER + getStringMark();
    }
}
