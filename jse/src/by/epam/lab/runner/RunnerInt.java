package by.epam.lab;

import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.ResultImplCsv;
import by.epam.lab.factory.ResultFactory;
import by.epam.lab.util.Constants;

public class RunnerInt {
    public static void main(String[] args) {
        ResultDao reader = new ResultImplCsv(Constants.FILE_NAME_CSV_1);
        ResultFactory resultFactory = new ResultFactory();
        RunnerLogic.execute(reader, resultFactory);
    }
}
