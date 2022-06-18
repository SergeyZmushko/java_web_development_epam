package by.epam.lab.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Data {
    public static String getProperties(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(Constants.FILE_NAME));
        return properties.getProperty(key);
    }
}
