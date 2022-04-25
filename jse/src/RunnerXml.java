
import by.epam.lab.bean.TestXml;

import by.epam.lab.strategy.XmlDb;
import by.epam.lab.util.Constants;

import java.sql.SQLException;
import java.util.LinkedList;

public class RunnerXml {
    public static void main(String[] args) {
        XmlDb xmlDb = new XmlDb();
        try {
            xmlDb.fillDb(Constants.FILE_NAME_XML);
            xmlDb.printMeanMarks();
            LinkedList<TestXml> csvTests = xmlDb.currentMonthResults();
            xmlDb.printList(csvTests);
            xmlDb.printLastDayResult(csvTests);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}

