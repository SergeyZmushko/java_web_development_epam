import by.epam.lab.CSV.ParseCSV;
import by.epam.lab.DBConnection.DB;
import by.epam.lab.bean.Test;

import java.sql.SQLException;
import java.util.LinkedList;


public class RunnerCsvInt {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DB db = new DB();
        ParseCSV parseCSV = new ParseCSV();
        parseCSV.insertStudents();
        db.printMeanMark();
        LinkedList<Test> tests = db.getSortedDateList();
        db.printList(tests);
        if (!tests.isEmpty()){
            System.out.println(tests.getLast());
        }
    }
}
