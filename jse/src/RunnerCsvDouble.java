import by.epam.lab.bean.TestDoubleCsv;

import by.epam.lab.strategy.CsvDoubleDb;

import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.LinkedList;

public class RunnerCsvDouble {
    public static void main(String[] args) {
        CsvDoubleDb doubleDb = new CsvDoubleDb();
        try {
            doubleDb.fillDb(Constants.FILE_NAME_CSV_2);
            doubleDb.printMeanMarks();
            LinkedList<TestDoubleCsv> csvTests = doubleDb.currentMonthResults();
            doubleDb.printList(csvTests);
            doubleDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}

