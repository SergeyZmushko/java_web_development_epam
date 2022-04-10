package by.epam.lab.bean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static by.epam.lab.util.Constants.*;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    public Result(){

    }

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String test, String date, String mark) throws ParseException {
        this(login, test, INPUT_DATE_FORMAT.parse(date), (int) (Double.parseDouble(mark) * 10));
    }

    private final static SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat(OUTPUT_DATE);
    private final static SimpleDateFormat INPUT_DATE_FORMAT = new SimpleDateFormat(INPUT_DATE);

    public String getStringDate(){
        return OUTPUT_DATE_FORMAT.format(date);
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

    public void setMark(String mark){
        double dMark = Double.parseDouble(mark);
        this.mark = (int)(dMark * 10);
    }

    private String getStringMark(){
        return (mark / 10) + DOT + (mark % 10);
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

    public String toString(){
        return login + SEPARATOR_SEMICOLON + test + SEPARATOR_SEMICOLON + getStringDate() + SEPARATOR_SEMICOLON + getStringMark();
    }
}
