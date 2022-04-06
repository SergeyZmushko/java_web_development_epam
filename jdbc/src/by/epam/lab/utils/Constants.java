package by.epam.lab.utils;

public class Constants {
    public final static String USER = "root";
    public final static String PASSWORD = "root";
    public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/segments?serverTimezone=Europe/Minsk";
    public final static String SQL_SELECT_LEN_NUM = "SELECT round(abs(x2 - x1)) AS len, COUNT(*) AS num" +
            " FROM coordinates GROUP BY 1 ORDER BY 1";
    public final static String SQL_DELETE_FROM_FREQUENCIES = "DELETE FROM frequencies";
    public final static String SQL_INSERT_INTO_FREQUENCIES = "INSERT INTO frequencies (len, num) VALUES (?, ?)";
    public final static String SQL_SELECT_FROM_FREQUENCIES_LEN_MORE_NUM = "SELECT len, num FROM frequencies WHERE len>num";
    public final static String SPLITTER = ";";
    public final static int LEN_IND = 1;
    public final static int NUM_IND = 2;

}
