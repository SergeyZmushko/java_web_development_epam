package by.epam.lab.factory;

import by.epam.lab.bean.HalfResult;
import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.impl.ResultImplCsv;
import by.epam.lab.util.Constants;

import java.sql.Date;

public class HalfResultFactory extends ResultFactory {

    public Result getResultFromFactory(String login, String test, Date date, int mark) {
        return new HalfResult(login, test, date, mark);
    }

    public Result getResultFromFactory(String login, String test, String date, String mark) {
        return new HalfResult(login, test, date, mark);
    }

    public ResultDao getResultDaoFromFactory(String fileName) throws DaoException {
        return new ResultImplCsv(fileName);
    }

    public double getRightAvgMark(double mark) {
        return mark / Constants.FORMAT_COEFFICIENT_10;
    }
}
