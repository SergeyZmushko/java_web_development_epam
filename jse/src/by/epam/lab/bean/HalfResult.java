package by.epam.lab.bean;

import java.sql.Date;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.Constants.REPLACEMENT;

public class HalfResult extends Result{
    public HalfResult(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public HalfResult(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    public String markToString(){
        return (getMark() / FORMAT_COEFFICIENT_10 + DOT + getMark() % FORMAT_COEFFICIENT_10).replaceAll(REPLACE_REGEX, REPLACEMENT);
    }
}
