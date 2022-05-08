package by.epam.lab.factory;


import by.epam.lab.bean.DecimalResult;
import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.impl.ResultImplXml;

import java.sql.Date;

public class DecimalResultFactory extends ResultFactory {

    public Result getResultFromFactory(String login, String test, Date date, int mark) {
        return new DecimalResult(login, test, date, mark);
    }

    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new DecimalResult(login, test, date, mark);
    }

    public ResultDao getResultDaoFromFactory(String fileName) {
        return new ResultImplXml(fileName);
    }

    public double getRightAvgMark(double mark) {
        return mark / 10;
    }
}
