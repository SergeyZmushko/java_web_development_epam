package by.epam.lab.CSV;

import by.epam.lab.DBConnection.DB;

import by.epam.lab.bean.Test;
import by.epam.lab.util.Constants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class ParseCSV implements CsvDAO {

    @Override
    public void insertStudents() throws SQLException, ClassNotFoundException {
        DB db = new DB();
        db.clearTables();
        try (Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME_CSV_1))){
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(";");
                Test test = new Test(str[0], str[1], str[2], str[3]);
                db.insertStudent(test);
            }
        } catch (FileNotFoundException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}





