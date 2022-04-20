import by.epam.lab.strategy.CsvDb;
import by.epam.lab.strategy.Context;
import by.epam.lab.util.Constants;

import java.sql.SQLException;

public class RunnerCsvInt {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new CsvDb());
        try{
            context.executeActivity(Constants.FILE_NAME_CSV_1);
        } catch (SQLException | ClassNotFoundException e){
            System.err.println(e);
        }
    }
}
