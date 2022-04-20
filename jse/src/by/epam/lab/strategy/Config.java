package by.epam.lab.strategy;

import by.epam.lab.bean.Test;
import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.impl.DbStrategy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static by.epam.lab.util.DBConstants.*;

public abstract class Config implements DbStrategy {
    Db db = new Db();

    @Override
    public abstract void fillDb(String filename) throws SQLException, ClassNotFoundException;

    @Override
    public void printMeanMarks() throws SQLException, ClassNotFoundException {
        System.out.println("Print mean mark");
        ResultSet resultSet = db.getMeanMarkRequest();
        while (resultSet.next()) {
            String login = resultSet.getString(LOGIN_IND);
            double avgMark = resultSet.getDouble(AVG_MARK_IND);
            System.out.printf("%s:%.2f\n", login, avgMark);
        }
    }

    @Override
    public void printLastDayResult(LinkedList<Test> tests) {
        System.out.println("Last day result");
        if (!tests.isEmpty()) {
            System.out.println(tests.getLast());
        }
    }

    @Override
    public LinkedList<Test> currentMonthResults() throws SQLException, ClassNotFoundException {
        LinkedList<Test> sortedDateList = new LinkedList<>();
        ResultSet resultSet = db.getSortedDateListRequest();
        while (resultSet.next()) {
            Test test = new Test(resultSet.getString(LOGIN_IND),
                    resultSet.getString(TEST_IND),
                    resultSet.getDate(DATE_IND),
                    resultSet.getInt(MARK_IND));
            sortedDateList.add(test);
        }
        return sortedDateList;
    }

    @Override
    public void printList(List<Test> tests) {
        System.out.println("Print tests on April");
        for (Test test : tests) {
            System.out.println(test);
        }
    }
}
