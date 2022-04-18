package by.epam.lab.DBConnection;

import by.epam.lab.bean.Test;
import by.epam.lab.util.DBConstants;
import static by.epam.lab.util.DBConstants.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DB implements DBConnect {

    public Connection getDBConnect() throws ClassNotFoundException, SQLException {
        Class.forName(DBConstants.CLASS_NAME);
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public void insertStudent(Test test) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_LOGINS);
        ps.setString(LOGIN_IND, test.getLogin());
        ps.setString(TEST_IND, test.getLogin());
        ps.executeUpdate();
        ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_TESTS);
        ps.setString(LOGIN_IND, test.getTest());
        ps.setString(TEST_IND, test.getTest());
        ps.executeUpdate();
        ps = getDBConnect().prepareStatement(SQL_INSERT_INTO_RESULTS);
        ps.setString(LOGIN_IND, test.getLogin());
        ps.setString(TEST_IND, test.getTest());
        ps.setDate(DATE_IND, test.getDate());
        ps.setInt(MARK_IND, test.getMark());
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

    public void printMeanMark() throws SQLException, ClassNotFoundException {
        Statement st = getDBConnect().createStatement();
        ResultSet resultSet = st.executeQuery(SQL_SELECT_AVG_MARK);
        while (resultSet.next()){
            String login = resultSet.getString(LOGIN_IND);
            double avgMark = resultSet.getDouble(AVG_MARK_IND);
            System.out.println(login + ":" + avgMark);
        }
    }

    public LinkedList<Test> getSortedDateList() throws SQLException, ClassNotFoundException {
        LinkedList<Test> sortedDateList = new LinkedList<>();
        Statement st = getDBConnect().createStatement();
        ResultSet resultSet = st.executeQuery(SQL_SELECT_CURRENT_MONTH_ASC);
        while (resultSet.next()){
            Test test = new Test(resultSet.getString(LOGIN_IND),
                    resultSet.getString(TEST_IND),
                    resultSet.getDate(DATE_IND),
                    resultSet.getInt(MARK_IND));
            sortedDateList.add(test);
        }
        return sortedDateList;
    }

    public void printList(List<Test> tests){
        for (Test test : tests){
            System.out.println(test);
        }
    }

    public void printLatestDayResult(LinkedList<Test> tests){
        if (!tests.isEmpty()){
            System.out.println(tests.getLast());
        }
    }


}





