package by.epam.lab.strategy;

import by.epam.lab.bean.TestIntCsv;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

public class CsvIntDb extends Config {
    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            db.clearTables();
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(DELIMITER);
                db.insertStudent(new TestIntCsv(str[LOGIN_IND], str[TEST_IND], str[DATE_IND], str[MARK_IND]));
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
    }

    public LinkedList<TestIntCsv> currentMonthResults() throws SQLException, ClassNotFoundException {
        LinkedList<TestIntCsv> sortedDateList = new LinkedList<>();
        ResultSet resultSet = db.getSortedDateListRequest();
        while (resultSet.next()) {
            sortedDateList.add(new TestIntCsv(resultSet.getString(LOGIN_IND_DB),
                    resultSet.getString(TEST_IND_DB),
                    resultSet.getDate(DATE_IND_DB),
                    resultSet.getInt(MARK_IND_DB)));
        }
        if (sortedDateList.isEmpty()) {
            System.out.println(NO_DATA);
        }
        return sortedDateList;
    }
}