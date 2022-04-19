package by.epam.lab.strategy;

import by.epam.lab.bean.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

public class CsvDb extends Config {
    @Override
    public void fillDb(String filename) throws SQLException, ClassNotFoundException {
        db.clearTables();
        try (Scanner sc = new Scanner(new FileReader(filename))){
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
