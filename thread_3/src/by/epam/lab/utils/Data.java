package by.epam.lab.utils;

import by.epam.lab.exceptions.ParseDataException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Data {

    public static String getProperties(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(Constants.FILE_NAME));
        } catch (IOException e) {
            System.err.println(Constants.WRONG_DATA + e.getMessage());
            throw new ParseDataException(e);
        }
        return properties.getProperty(key);
    }
}
