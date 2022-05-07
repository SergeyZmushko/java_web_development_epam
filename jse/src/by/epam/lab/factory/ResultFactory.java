package by.epam.lab.factory;

import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.impl.ResultImplCsv;
import by.epam.lab.bean.Result;

import java.sql.Date;

public class ResultFactory {
    public Result getResultFromFactory(String login, String test, Date date, int mark){
        return new Result(login, test, date, mark);
    }

    public ResultDao getResultDaoFromFactory(String fileName){
        return new ResultImplCsv(fileName);
    }
}
