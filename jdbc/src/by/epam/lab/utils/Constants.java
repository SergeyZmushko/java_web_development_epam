package by.epam.lab.utils;

public class Constants {
    public final static String USER = "root";
    public final static String PASSWORD = "root";
    public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/segments?serverTimezone=Europe/Minsk";
    public final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public final static String SQL_SELECT_LEN_NUM = "select round(abs(x1 - x2), 0) as len, count(*) as num from coordinates group by len order by len asc";
    public final static String SQL_DELETE_FROM_FREQUENCIES = "delete from frequencies";
    public final static String SQL_INSERT_INTO_FREQUENCIES = "insert into frequencies (len, num) values (?, ?)";
    public final static String SQL_SELECT_FROM_FREQUENCIES_LEN_MORE_NUM = "SELECT * FROM frequencies where len > num";
    public final static String SPLITTER = ";";
    }
