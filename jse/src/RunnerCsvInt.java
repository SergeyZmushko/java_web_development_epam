
import by.epam.lab.bean.TestIntCsv;
import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.CsvIntDb;
import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.List;


public class RunnerCsvInt {
    public static void main(String[] args) {
        Db db= new Db();
        CsvIntDb csvIntDb = new CsvIntDb();
        try {
            csvIntDb.fillDb(Constants.FILE_NAME_CSV_1);
            csvIntDb.printMeanMarks();
            List<TestIntCsv> csvTests = csvIntDb.currentMonthResults();
            csvIntDb.printList(csvTests);
            csvIntDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }finally {
            db.closePrepareStatement();
            db.closeStatement();
            db.closeConnection();
        }
    }
}
