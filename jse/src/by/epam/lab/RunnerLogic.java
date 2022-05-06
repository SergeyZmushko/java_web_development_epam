package by.epam.lab;

import by.epam.lab.bean.Result;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;

public class RunnerLogic {
    public static void execute(ResultDao reader, ResultFactory resultFactory) {
        try {
            ResultLoader.loadResults(reader);
            Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            PreparedStatement ps = cn.prepareStatement(SQL_SELECT_AVG_MARK);
            try (ResultSet rs = ps.executeQuery(SQL_SELECT_AVG_MARK)) {
                while (rs.next()) {
                    String login = rs.getString(LOGIN_IND_DB);
                    double avgMark = rs.getDouble(AVG_MARK_IND_DB);
                    System.out.printf(FORMAT_STRING_MEAN_MARK, login, (int) avgMark / FORMAT_COEFFICIENT_10,
                            (int) (avgMark * FORMAT_COEFFICIENT_10 % FORMAT_COEFFICIENT_100));
                }
            }
            try (ResultSet rs = ps.executeQuery(SQL_SELECT_CURRENT_MONTH_ASC)) {
                List<Result> results = new LinkedList<>();
                while (rs.next()) {
                    Result result = resultFactory.getResultFromFactory(rs.getString("login"), rs.getString("test"),
                            rs.getDate("date"), rs.getInt("mark"));
                    System.out.println(result);
                    results.add(result);
                }
                for (Result result : results) {
                    System.out.println(result);
                }
                if (!results.isEmpty()) {
                    System.out.println(LAST_DAYS_RESULT);
                    Result lastResult = results.get(results.size() - GET_LAST_IND_LIST);
                    for (Result result : results) {
                        if (result.getDate().equals(lastResult.getDate())) {
                            System.out.println(result);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
