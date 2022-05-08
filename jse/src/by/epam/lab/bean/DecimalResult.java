package by.epam.lab.bean;

import java.sql.Date;
import static by.epam.lab.util.Constants.*;

public class DecimalResult extends Result{

    public DecimalResult(String login, String test, Date date, int mark) {
        super(login, test, date, mark);
    }

    public DecimalResult(String login, String test, String date, String mark) {
        super(login, test, date, mark);
    }

    public String markToString(){
        return getMark() / FORMAT_COEFFICIENT_10 + DOT + getMark() % FORMAT_COEFFICIENT_10;
    }
}
