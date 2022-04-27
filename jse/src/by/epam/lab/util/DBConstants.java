package by.epam.lab.util;

public class DBConstants {
    public final static String USER = "jse";
    public final static String PASSWORD = "jse";
    public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/results";
    public final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    public final static int LOGIN_IND_DB = 1;
    public final static int TEST_IND_DB = 2;
    public final static int AVG_MARK_IND_DB = TEST_IND_DB;
    public final static int DATE_IND_DB = 3;
    public final static int MARK_IND_DB = 4;
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
    public final static String SQL_SELECT_AVG_MARK = "Select name, avg(mark) as avg\n" +
            "From logins, results\n" +
            "where logins.idLogin = results.loginId\n" +
            "group by loginId\n" +
            "order by avg DESC";
    public final static String SQL_SELECT_CURRENT_MONTH_ASC = "SELECT logins.name, tests.name, dat, mark\n" +
            "FROM logins, tests, results\n" +
            "Where logins.idLogin = results.loginId and\n" +
            "tests.idTest = results.testId and\n" +
            "month(results.dat) = month(now())and\n" +
            "year(results.dat) = year(now())\n" +
            "Order by dat Asc";
    public final static String MEAN_MARK = "Print mean mark";
    public final static String LAST_DAYS_RESULT = "Last day result";
    public final static String CURRENT_MONTH_TESTS = "Print tests on current month";
    public final static String FORMAT_STRING_MEAN_MARK = "%s:%d.%d\n";
    public final static String NO_DATA = "No data for current month";


}
