package by.epam.lab.utils;

public class ConstantsDAO {
	public final static String DELIMITER = ";";

	public final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/";
	
	public final static String SQL_SELECT_NUMBERS = "SELECT value FROM mvcstat2.data";
	public final static String SQL_PARAM_VALUE = "value";
	public final static int FACTORY_NAME_IND = 0;
	public final static int DB_NAME_IND = 0;
	public final static int USER_IND = 1;
	public final static int PASSWORD_IND = 2;
	public final static int ACCESS_SOURCE_PARAMS_IND = 1;
	public final static int SPLIT_LIMIT = 2;
	
	public final static int MIN_NUMBER = -1000;
	public final static int MAX_NUMBER = 1000;
	
	public final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	
	public final static String LOAD_CONNECTOR_ERROR = "Load connector error";
	public final static String DATA_BASE_ERROR = "Read from database error";
	public final static String LOAD_NUMBERS_ERROR = "Load result numbers error from ";
	public final static String LOAD_DB_DRIVER_ERROR = "Load database driver error";
	
	public final static String REAL_PATH = "/WEB-INF";
	public final static String EMPTY_PARAMS = "";
	public final static String NUMBERS_FOUND = "Few numbers found ";

}
