package by.epam.lab.util;

public class DBConstants {
    public final static String USER = "jse";
    public final static String PASSWORD = "jse";
    public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/results";
    public final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public final static int LOGIN_IND = 1;
    public final static int TEST_IND = 2;
    public final static int AVG_MARK_IND = TEST_IND;
    public final static int DATE_IND = 3;
    public final static int MARK_IND = 4;
    public final static String SQL_INSERT_INTO_LOGINS = "insert into logins (name) Select ? Where not exists(select * from logins where name = ?)";
    public final static String SQL_INSERT_INTO_TESTS = "insert into tests (name) Select ? Where not exists(select * from tests where name = ?)";
    public final static String SQL_INSERT_INTO_RESULTS = "INSERT INTO results (loginId, testId, dat, mark)\n" +
            "values( \n" +
            "(SELECT idLogin FROM logins WHERE name = ?),\n" +
            "(SELECT idTest FROM tests WHERE name = ?),\n" +
            "?, ?);";
    public final static String SQL_SET_FK_0 = "SET FOREIGN_KEY_CHECKS=0;";
    public final static String SQL_SET_FK_1 = "SET FOREIGN_KEY_CHECKS=1";
    public final static String SQL_TRUNCATE_RESULTS = "truncate TABLE results";
    public final static String SQL_TRUNCATE_LOGINS = "truncate TABLE logins";
    public final static String SQL_TRUNCATE_TESTS = "truncate TABLE tests";
    public final static String SQL_SELECT_AVG_MARK = "Select name, format((avg(format(mark, 2)) / 10), 2) as avg\n" +
            "From logins, results\n" +
            "where logins.idLogin = results.loginId\n" +
            "group by loginId\n" +
            "order by avg DESC";
    public final static String SQL_SELECT_CURRENT_MONTH_ASC = "SELECT logins.name, tests.name, dat, mark\n" +
            "FROM logins, tests, results\n" +
            "Where logins.idLogin = results.loginId and\n" +
            "tests.idTest = results.testId and\n" +
            "month(results.dat) = month(now())\n" +
            "Order by dat Asc";

}
