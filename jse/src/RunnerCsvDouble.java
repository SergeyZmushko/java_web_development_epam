import by.epam.lab.bean.TestDoubleCsv;

import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.impl.CsvDoubleDb;

import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.List;

public class RunnerCsvDouble {
    public static void main(String[] args) {
        Db db = new Db();
        CsvDoubleDb doubleDb = new CsvDoubleDb();
        try {
            doubleDb.fillDb(Constants.FILE_NAME_CSV_2);
            doubleDb.printMeanMarks();
            List<TestDoubleCsv> csvTests = doubleDb.currentMonthResults();
            doubleDb.printList(csvTests);
            doubleDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            db.closePrepareStatement();
            db.closeStatement();
            db.closeConnection();
        }
    }
}

