package by.epam.lab.service;

import by.epam.lab.util.ConnectionProvider;
import by.epam.lab.util.ResultLoader;
import by.epam.lab.bean.Result;
import by.epam.lab.factory.ResultFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;

public class RunnerLogic {
    static Connection cn = ConnectionProvider.getInstance();

    public static void execute(ResultFactory resultFactory, String fileName) {
        try {
            ResultLoader.loadResults(resultFactory.getResultDaoFromFactory(fileName, resultFactory));
            printAvgMarks(resultFactory);
            List<Result> results = getCurrentMonthResults(resultFactory);
            printCurrentMonthTests(results);
            printLastDayResults(results);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionProvider.closeConnection();
        }
    }

    private static void printLastDayResults(List<Result> results) {
        if (!results.isEmpty()) {
            System.out.println(LAST_DAYS_RESULT);
            ListIterator<Result> it = results.listIterator(results.size());
            Result lastResult = it.previous();
            System.out.println(lastResult);
            while (it.hasPrevious()) {
                Result currentResult = it.previous();
                if (lastResult.getDate().equals(currentResult.getDate())) {
                    System.out.println(currentResult);
                }
            }
        }
    }

    private static void printCurrentMonthTests(List<Result> results) {
        if (!results.isEmpty()) {
            System.out.println(CURRENT_MONTH_TESTS);
            for (Result result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println(NO_DATA);
        }
    }

    private static List<Result> getCurrentMonthResults(ResultFactory resultFactory) throws SQLException {
        List<Result> results = new LinkedList<>();
        try (PreparedStatement ps = cn.prepareStatement(SQL_SELECT_CURRENT_MONTH_ASC);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Result result = resultFactory.getResultFromFactory(rs.getString(LOGIN), rs.getString(TEST),
                        rs.getDate(DATE), rs.getInt(MARK));
                results.add(result);
            }
        }
        return results;
    }

    private static void printAvgMarks(ResultFactory resultFactory) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement(SQL_SELECT_AVG_MARK);
             ResultSet rs = ps.executeQuery(SQL_SELECT_AVG_MARK)) {
            System.out.println(MEAN_MARK);
            while (rs.next()) {
                String login = rs.getString(LOGIN_IND_DB);
                double avgMark = rs.getDouble(AVG_MARK_IND_DB);
                String result = String.format(FORMAT_STRING_MEAN_MARK, login, resultFactory.getRightAvgMark(avgMark)).replace(COMMA, DOT);
                System.out.printf(result);
            }
        }
    }
}

