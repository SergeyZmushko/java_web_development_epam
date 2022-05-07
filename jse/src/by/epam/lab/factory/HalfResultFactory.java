package by.epam.lab.factory;

import by.epam.lab.bean.HalfResult;
import by.epam.lab.bean.Result;

import java.sql.Date;

public class HalfResultFactory extends ResultFactory {

    public Result getResultFromFactory(String login, String test, Date date, double mark){
        return new HalfResult(login, test, date, (int) mark * 10);
    }

}
