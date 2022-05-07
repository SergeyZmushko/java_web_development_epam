package by.epam.lab.runner;

import by.epam.lab.dao.ResultDao;
import by.epam.lab.dao.impl.ResultImplXml;
import by.epam.lab.factory.DecimalResultFactory;
import by.epam.lab.factory.ResultFactory;
import by.epam.lab.util.Constants;

public class RunnerDecimal {
    public static void main(String[] args) {
        ResultDao reader = new ResultImplXml(Constants.FILE_NAME_XML);
        ResultFactory resultFactory = new DecimalResultFactory();
        RunnerLogic.execute(reader, resultFactory);
    }
}
