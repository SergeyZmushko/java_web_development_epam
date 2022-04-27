package by.epam.lab.strategy.impl;

import by.epam.lab.bean.Test;
import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.DbStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;

public abstract class Config implements DbStrategy {
    protected Db db = new Db();

    @Override
    public abstract void fillDb(String filename) throws SQLException, ClassNotFoundException;

    @Override
    public void printMeanMarks() throws SQLException, ClassNotFoundException {
        System.out.println(MEAN_MARK);
        ResultSet resultSet = db.getMeanMarkRequest();
        while (resultSet.next()) {
            String login = resultSet.getString(LOGIN_IND_DB);
            double avgMark = resultSet.getDouble(AVG_MARK_IND_DB);
            System.out.printf(FORMAT_STRING_MEAN_MARK, login, (int) avgMark / FORMAT_COEFFICIENT_10,
                    (int) (avgMark * FORMAT_COEFFICIENT_10 % FORMAT_COEFFICIENT_100));
        }
        Db.close(resultSet);
    }

    @Override
    public void printLastDayResult(List<? extends Test> tests) {
        if (!tests.isEmpty()) {
            System.out.println(LAST_DAYS_RESULT);
            Test lastTest = tests.get(tests.size() - GET_LAST_IND_LIST);
            for (Test test : tests) {
                if (test.getDate().equals(lastTest.getDate())) {
                    System.out.println(test);
                }
            }
        }
    }

    @Override
    public void printList(List<? extends Test> tests) {
        if (!tests.isEmpty()) {
            System.out.println(CURRENT_MONTH_TESTS);
            for (Test test : tests) {
                System.out.println(test);
            }
        }
    }
}
