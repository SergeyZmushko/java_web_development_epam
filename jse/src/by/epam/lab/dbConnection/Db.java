package by.epam.lab.dbConnection;

import by.epam.lab.bean.Test;
import by.epam.lab.util.DBConstants;

import static by.epam.lab.util.DBConstants.*;

import java.sql.*;

public class Db {

    public Connection getDBConnect() throws ClassNotFoundException, SQLException {
        Class.forName(DBConstants.CLASS_NAME);
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void insertStudent(Test test) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_LOGINS);
        ps.setString(LOGIN_IND_DB, test.getLogin());
        ps.setString(TEST_IND_DB, test.getLogin());
        ps.executeUpdate();
        ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_TESTS);
        ps.setString(LOGIN_IND_DB, test.getTest());
        ps.setString(TEST_IND_DB, test.getTest());
        ps.executeUpdate();
        ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_RESULTS);
        ps.setString(LOGIN_IND_DB, test.getLogin());
        ps.setString(TEST_IND_DB, test.getTest());
        ps.setDate(DATE_IND_DB, test.getDate());
        ps.setInt(MARK_IND_DB, test.getMark());
        ps.executeUpdate();
    }

    public void clearTables() throws SQLException, ClassNotFoundException {
        Statement st = getDBConnect().createStatement();
        st.executeUpdate(SQL_SET_FK_0);
        st.executeUpdate(SQL_TRUNCATE_LOGINS);
        st.executeUpdate(SQL_TRUNCATE_TESTS);
        st.executeUpdate(SQL_TRUNCATE_RESULTS);
        st.executeUpdate(SQL_SET_FK_1);
    }

    public ResultSet getMeanMarkRequest() throws SQLException, ClassNotFoundException {
        Statement st = getDBConnect().createStatement();
        return st.executeQuery(SQL_SELECT_AVG_MARK);
    }

    public ResultSet getSortedDateListRequest() throws SQLException, ClassNotFoundException {
        Statement st = getDBConnect().createStatement();
        return st.executeQuery(SQL_SELECT_CURRENT_MONTH_ASC);
    }
}





