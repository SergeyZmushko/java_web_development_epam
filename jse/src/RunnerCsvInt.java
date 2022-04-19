import by.epam.lab.strategy.CsvDb;
import by.epam.lab.strategy.Context;
import by.epam.lab.util.Constants;
import java.sql.SQLException;


public class RunnerCsvInt {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Context context = new Context();
        context.setStrategy(new CsvDb());
        context.executeActivity(Constants.FILE_NAME_CSV_1);
    }
}
