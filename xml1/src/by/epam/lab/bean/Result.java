package by.epam.lab.bean;
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

    public Result(String login, String test, String date, String mark) {
        this.login = login;
        this.test = test;
        this.date = new Date(date);
        setMark(mark);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setDate(Date date) {
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
        return String.format(MARK_FORMAT, mark / 10, mark % 10);
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
        return login + SEPARATOR_SEMICOLON + test + SEPARATOR_SEMICOLON + date + SEPARATOR_SEMICOLON + getStringMark();
    }
}
