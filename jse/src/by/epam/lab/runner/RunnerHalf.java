package by.epam.lab.runner;

import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.impl.ResultImplCsv;
import by.epam.lab.factory.ResultFactory;
import by.epam.lab.util.Constants;

public class RunnerHalf {
    public static void main(String[] args) {
        ResultDao reader = new ResultImplCsv(Constants.FILE_NAME_CSV_2);
        ResultFactory resultFactory = new ResultFactory();
        RunnerLogic.execute(reader, resultFactory);
    }
}
