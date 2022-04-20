package by.epam.lab.dbConnection;

import by.epam.lab.bean.Test;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnect {
    Connection getDBConnect() throws ClassNotFoundException, SQLException;

    void insertStudent(Test test) throws SQLException, ClassNotFoundException;

}
