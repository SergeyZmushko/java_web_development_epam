package by.epam.lab.strategy.impl;

import by.epam.lab.bean.TestDoubleCsv;
import by.epam.lab.dbConnection.Db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import static by.epam.lab.util.Constants.*;
import static by.epam.lab.util.DBConstants.*;


public class CsvDoubleDb extends Config {
    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            db.clearTables();
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(DELIMITER);
                db.insertStudent(new TestDoubleCsv(str[LOGIN_IND], str[TEST_IND], str[DATE_IND], str[MARK_IND]));
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND);
        }
    }

    public LinkedList<TestDoubleCsv> currentMonthResults() throws SQLException, ClassNotFoundException {
        LinkedList<TestDoubleCsv> sortedDateList = new LinkedList<>();
        ResultSet resultSet = db.getSortedDateListRequest();
        while (resultSet.next()) {
            sortedDateList.add(new TestDoubleCsv(resultSet.getString(LOGIN_IND_DB),
                    resultSet.getString(TEST_IND_DB),
                    resultSet.getDate(DATE_IND_DB),
                    resultSet.getInt(MARK_IND_DB)));
        }
        Db.close(resultSet);
        if (sortedDateList.isEmpty()) {
            System.out.println(NO_DATA);
        }
        return sortedDateList;
    }
}
