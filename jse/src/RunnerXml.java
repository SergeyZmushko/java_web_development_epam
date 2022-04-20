import by.epam.lab.strategy.Context;
import by.epam.lab.strategy.XmlDb;
import by.epam.lab.util.Constants;

import java.sql.SQLException;

public class RunnerXml {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new XmlDb());
        try {
            context.executeActivity(Constants.FILE_NAME_XML);
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}

