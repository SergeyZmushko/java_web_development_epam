package by.epam.lab.util;

import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;

import java.sql.*;

import static by.epam.lab.util.DBConstants.*;

public class ResultLoader {

    public static void loadResults(ResultDao reader) {
        try (Connection cn = ConnectionProvider.getConnection();
             Statement st = cn.createStatement()) {
            st.executeUpdate(SQL_TRUNCATE_RESULTS);
            PreparedStatement psSelectLogin = cn.prepareStatement(SELECT_LOGIN);
            PreparedStatement psInsertLogin = cn.prepareStatement(INSERT_LOGIN);
            PreparedStatement psSelectTest = cn.prepareStatement(SELECT_TEST);
            PreparedStatement psInsertTest = cn.prepareStatement(INSERT_TEST);
            PreparedStatement psInsertResult = cn.prepareStatement(SQL_INSERT_INTO_RESULTS);
            while (reader.hasResult()) {
                Result result = reader.nextResult();
                int idLogin = getId(result.getLogin(), psSelectLogin, psInsertLogin);
                int idTest = getId(result.getTest(), psSelectTest, psInsertTest);
                psInsertResult.setInt(ID_LOGIN_DB_IND, idLogin);
                psInsertResult.setInt(ID_TEST_DB_IND, idTest);
                psInsertResult.setDate(DATE_DB_IND, result.getDate());
                psInsertResult.setInt(MARK_DB_IND, result.getMark());
                psInsertResult.addBatch();
            }
            psInsertResult.executeBatch();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static int getId(String tableName, PreparedStatement psSelect, PreparedStatement psInsert) throws SQLException {
        psSelect.setString(LOGIN_IND_DB, tableName);
        ResultSet resultSet = psSelect.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(LOGIN_IND_DB);
        } else {
            psInsert.setString(LOGIN_IND_DB, tableName);
            return psInsert.executeUpdate();
        }
    }
}
