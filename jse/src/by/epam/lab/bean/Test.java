package by.epam.lab.bean;

import java.sql.Date;

public class Test {
    private String login;
    private String test;
    private Date date;
    private int mark;

    public Test(String login, String test, Date date, int mark){
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Test(String login, String test, String date, String mark) {
        this.login = login;
        this.test = test;
        this.date = Date.valueOf(date);
        this.mark = Integer.parseInt(mark);
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
        return login + ";" + test + ';' + date + ";" + mark;
    }
}
