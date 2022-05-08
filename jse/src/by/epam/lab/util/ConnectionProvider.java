package by.epam.lab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static by.epam.lab.util.DBConstants.*;

public class ConnectionProvider {

    private static Connection INSTANCE;

    private ConnectionProvider(){
    }

    public static Connection getConnection() {
        if (INSTANCE == null){
            try {
                INSTANCE = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return INSTANCE;
    }
}
