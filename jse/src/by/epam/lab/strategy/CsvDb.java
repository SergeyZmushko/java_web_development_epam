package by.epam.lab.strategy;

import by.epam.lab.bean.Test;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.Constants.FILE_NOT_FOUND;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class CsvDb extends Config {
    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            db.clearTables();
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(DELIMITER);
                Test test = new Test(str[LOGIN_IND], str[TEST_IND], str[DATE_IND], str[MARK_IND]);
                db.insertStudent(test);
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
    }
}
