package by.epam.lab;

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
