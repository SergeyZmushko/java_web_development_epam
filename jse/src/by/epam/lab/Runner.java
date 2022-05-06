package by.epam.lab;

import java.io.IOException;
import java.sql.SQLException;

import static by.epam.lab.util.Constants.*;
public class Runner {
    public static void main(String[] args) {
        ResultDao reader = null;
        try {
            reader = new ResultImplCsv(FILE_NAME_CSV_1);
            ResultLoader.loadResults(reader);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }
}
