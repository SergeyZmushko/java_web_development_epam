package by.epam.lab;

import by.epam.lab.util.Constants;

public class RunnerInt {
    public static void main(String[] args) {
        ResultDao reader = new ResultImplCsv(Constants.FILE_NAME_CSV_1);
        ResultFactory resultFactory = new ResultFactory();
        RunnerLogic.execute(reader, resultFactory);
    }
}
