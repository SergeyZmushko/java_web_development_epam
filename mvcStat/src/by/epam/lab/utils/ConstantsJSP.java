package by.epam.lab.utils;

public class ConstantsJSP {
	public final static String OPERATION_NAME = "operation";
	public final static String STAT_NAME = "stats";
	public final static String NUMBER_NAME = "number";
	public final static String RESULT_NAME = "result";
	public final static String NUMBERS_NAME = "numbers";
	public final static String REFERER_HEADER = "referer";
	public final static String MAX_VALUE_NAME = "maxValue";

	public final static String START_PAGE_URL = "/start.jsp";
	public final static String RESULT_PAGE_URL = "/result.jsp";
	
	public final static String DELIMITER = ";";
	public final static String MEMORY_INITIALIZATION_PARAM = "memory";
	public final static String CSV_INITIALIZATION_PARAM = "csv;E:/java_web_development_epam/mvcStat/webapp/WEB-INF/resources/numbers.csv";
	public final static String DB_INITIALIZATION_PARAM = "db;mvcStat2;epamlab;111";
	public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/";
	
	public final static String SQL_SELECT_NUMBERS = "SELECT value FROM mvcstat2.data";
	public final static String SQL_PARAM_VALUE = "value";
	public final static int FACTORY_NAME = 0;
	public final static int DB_NAME_IND = 1;
	public final static int USER_IND = 2;
	public final static int PASSWORD_IND = 3;
	public final static int FILE_NAME_IND = 1;
	
	public final static int MIN_NUMBER = -1000;
	public final static int MAX_NUMBER = 1000;
	
	public final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	public final static String LOAD_CONNECTOR_ERROR = "Load connector error";
	public final static String DATA_BASE_ERROR = "Read from database error";
	public final static String NUMBERS_FOUND = "Few numbers found ";
	public final static String FILE_NOT_FOUND = "File is not found";
}
