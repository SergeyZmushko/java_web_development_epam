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

    public static void execute(ResultFactory resultFactory, String fileName) {
        try (Connection cn = ConnectionProvider.getConnection()) {
            ResultLoader.loadResults(resultFactory.getResultDaoFromFactory(fileName));
            PreparedStatement ps = cn.prepareStatement(SQL_SELECT_AVG_MARK);
            try (ResultSet rs = ps.executeQuery(SQL_SELECT_AVG_MARK)) {
                System.out.println(MEAN_MARK);
                while (rs.next()) {
                    String login = rs.getString(LOGIN_IND_DB);
                    double avgMark = rs.getDouble(AVG_MARK_IND_DB);
                    System.out.println(login + DELIMITER + resultFactory.getRightAvgMark(avgMark));
                }
            }
            try (ResultSet rs = ps.executeQuery(SQL_SELECT_CURRENT_MONTH_ASC)) {
                List<Result> results = new LinkedList<>();
                while (rs.next()) {
                    Result result = resultFactory.getResultFromFactory(rs.getString(LOGIN), rs.getString(TEST),
                            rs.getDate(DATE), rs.getInt(MARK));
                    results.add(result);
                }
                if (!results.isEmpty()) {
                    System.out.println(CURRENT_MONTH_TESTS);
                    for (Result result : results) {
                        System.out.println(result);
                    }
                    System.out.println(LAST_DAYS_RESULT);
                    ListIterator<Result> it = results.listIterator(results.size());
                    Result lastResult = it.previous();
                    System.out.println(lastResult);
                    while (it.hasPrevious()) {
                        if (lastResult.getDate().equals(it.previous().getDate())) {
                            System.out.println(lastResult);
                        }
                    }
                } else {
                    System.out.println(NO_DATA);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
