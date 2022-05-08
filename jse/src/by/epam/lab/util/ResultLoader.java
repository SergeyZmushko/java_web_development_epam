package by.epam.lab.util;

import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;

import java.sql.*;

import static by.epam.lab.util.DBConstants.*;

public class ResultLoader {

    public static void loadResults(ResultDao reader) {
        try {
            Connection cn = ConnectionProvider.getConnection();
            Statement st = cn.createStatement();
            st.executeUpdate(SQL_SET_FK_0);
            st.executeUpdate(SQL_TRUNCATE_LOGINS);
            st.executeUpdate(SQL_TRUNCATE_TESTS);
            st.executeUpdate(SQL_TRUNCATE_RESULTS);
            st.executeUpdate(SQL_SET_FK_1);
            PreparedStatement psSelectLogin = cn.prepareStatement(SELECT_LOGIN);
            PreparedStatement psInsertLogin = cn.prepareStatement(INSERT_LOGIN);
            PreparedStatement psSelectTest = cn.prepareStatement(SELECT_TEST);
            PreparedStatement psInsertTest = cn.prepareStatement(INSERT_TEST);
            PreparedStatement psInsertResult = cn.prepareStatement(SQL_INSERT_INTO_RESULTS);
            while (reader.hasResult()) {
                Result result = reader.nextResult();
                String login = result.getLogin();
                String test = result.getTest();
                int idLogin = getId(login, psSelectLogin, psInsertLogin);
                int idTest = getId(test, psSelectTest, psInsertTest);
                psInsertResult.setInt(ID_LOGIN_DB_IND, idLogin);
                psInsertResult.setInt(ID_TEST_DB_IND, idTest);
                psInsertResult.setDate(DATE_DB_IND, result.getDate());
                psInsertResult.setInt(MARK_DB_IND, result.getMark());
                psInsertResult.addBatch();
                psInsertResult.executeBatch();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static int getId(String login, PreparedStatement psSelect, PreparedStatement psInsert) throws SQLException {
        psSelect.setString(LOGIN_IND_DB, login);
        ResultSet resultSet = psSelect.executeQuery();
        if (!resultSet.next()) {
            psInsert.setString(LOGIN_IND_DB, login);
            psInsert.executeUpdate();
        }
        ResultSet resultSet1 = psSelect.executeQuery();
        resultSet1.next();
        return resultSet1.getInt(ID_LOGIN_DB_IND);
    }
}
