package by.epam.lab.utils;

import by.epam.lab.beans.Purchase;

public class Constant {
    public final static String FILE_NAME = "src/in.csv";
    public final static int INDEX_DIFFERENCE = Purchase.class.getDeclaredFields().length;
    public final static int NAME_INDEX = 0;
    public final static int PRICE_INDEX = 1;
    public final static int NUMBER_INDEX = 2;
    public final static int DISCOUNT_INDEX = 3;
    public final static int PRIME_NUMBER_31 = 31;
    public final static int ONE_HUNDRED = 100;
    public final static String MILK = "milk";
    public final static String MEAT = "meat";
    public final static String BREAD = "bread";
    public final static String ARROW = "=>";
    public final static String SEPARATOR = ";";
    public final static String COLON = " : ";
    public final static String FORMAT_STRING_TO_BYN = "%d.%02d";
    public final static String FILE_NOT_FOUND = "Input file is not found";
    public final static String FIRST_DAY_MAP = "FirstDayMap";
    public final static String LAST_DAY_MAP = "LastDayMap";
    public final static String FIRST_DAY_MAP_AFTER_REMOVE = "FirstDayMap after removing";
    public final static String LAST_DAY_MAP_AFTER_REMOVE = "LastDayMap after removing";
    public final static String DAY_PURCHASE_MAP = "DayPurchaseMap";
    public final static String DAY_PURCHASE_MAP_AFTER_REMOVE = "DayPurchaseMap after removing";
    public final static String PURCHASE_IS_NOT_FOUND = "Purchase is not found";
    public final static String FIND_MONDAY_PURCHASE = "Purchases on Monday";
    public final static String FIND_BREAD_155_FIRST = "First day purchase bread 1.55";
    public final static String FIND_BREAD_155_LAST = "Last day purchase bread 1.55";
    public final static String FIND_BREAD_170 = "Find bread 1.70";
}
