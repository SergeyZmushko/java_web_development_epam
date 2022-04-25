package by.epam.lab.strategy;

import by.epam.lab.bean.Test;
import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.impl.DbStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static by.epam.lab.util.Constants.FORMAT_COEFFICIENT_100;
import static by.epam.lab.util.DBConstants.*;
import static by.epam.lab.util.Constants.FORMAT_COEFFICIENT_10;

public abstract class Config implements DbStrategy {
    Db db = new Db();

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
    }

    @Override
    public void printLastDayResult(LinkedList<? extends Test> tests) {
        System.out.println(LAST_DAYS_RESULT);
        if (!tests.isEmpty()) {
            Test test = tests.getLast();
            for (Test test1 : tests) {
                if (test.getDate().equals(test1.getDate())) {
                    System.out.println(test1);
                }
            }
        }
    }

    @Override
    public void printList(List<? extends Test> tests) {
        System.out.println(CURRENT_MONTH_TESTS);
        for (Test test : tests) {
            System.out.println(test);
        }
    }
}
