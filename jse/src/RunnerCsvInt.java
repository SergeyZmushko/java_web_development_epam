
import by.epam.lab.bean.TestIntCsv;
import by.epam.lab.strategy.CsvIntDb;
import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.LinkedList;


public class RunnerCsvInt {
    public static void main(String[] args) {
        CsvIntDb csvIntDb = new CsvIntDb();
        try {
            csvIntDb.fillDb(Constants.FILE_NAME_CSV_1);
            csvIntDb.printMeanMarks();
            LinkedList<TestIntCsv> csvTests = csvIntDb.currentMonthResults();
            csvIntDb.printList(csvTests);
            csvIntDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
