package by.epam.lab.utils;

import java.io.IOException;

public class Constants {
    public final static String FILE_NAME = "src/by/epam/lab/data.properties";
    public final static String DELIMITER = ";";
    public final static String FORMAT_CSV = "%s;%s;%s\n";
    public final static String FILE_NOT_FOUND = "File is not found";
    public final static String FOLDER_NAME = "folderName";
    public final static String MAX_PRODUCERS_NUMBER = "maxProducersNumber";
    public final static String MAX_CONSUMERS_NUMBER = "maxConsumersNumber";
    public final static String BUFFER_STR_LENGTH = "bufferStrLength";
    public final static String RESULT_FILE_NAME = "resultFileName";
    public final static String EXCEPTION = "Exception: ";
    public final static int PRIME_NUMBER = 31;
    public final static int NAME_NULL_HASH = 0;
    public final static int NAME_INDEX = 0;
    public final static int MARK1_INDEX = 1;
    public final static int MARK2_INDEX = 2;
    public final static String DONE = "Done";
    public final static int MAX_PRODUCERS_NUMBER_VALUE;
    public final static int MAX_CONSUMERS_NUMBER_VALUE;
    public final static String FOLDER_NAME_VALUE;
    public final static int BUFFER_STR_LENGTH_VALUE;
    static {
        try {
            MAX_PRODUCERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
            MAX_CONSUMERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
            FOLDER_NAME_VALUE = Data.getProperties(FOLDER_NAME);
            BUFFER_STR_LENGTH_VALUE = Integer.parseInt(Data.getProperties(BUFFER_STR_LENGTH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
