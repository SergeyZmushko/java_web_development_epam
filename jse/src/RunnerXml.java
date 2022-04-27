
import by.epam.lab.bean.TestXml;

import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.impl.XmlDb;
import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.List;

public class RunnerXml {
    public static void main(String[] args) {
        Db db = new Db();
        XmlDb xmlDb = new XmlDb();
        try {
            xmlDb.fillDb(Constants.FILE_NAME_XML);
            xmlDb.printMeanMarks();
            List<TestXml> csvTests = xmlDb.currentMonthResults();
            xmlDb.printList(csvTests);
            xmlDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            db.closePrepareStatement();
            db.closeStatement();
            db.closeConnection();
        }
    }
}

