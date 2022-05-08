package by.epam.lab.dao.impl;

import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;
import by.epam.lab.factory.ResultFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.epam.lab.util.Constants.*;

public class ResultImplCsv implements ResultDao {
    private Scanner scanner;

    public ResultImplCsv(String fileName) {
        try {
            scanner = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
            e.printStackTrace();
        }
    }

    @Override
    public Result nextResult() {
        String[] str = scanner.next().split(DELIMITER);
        return new ResultFactory().getResultFromFactory(str[LOGIN_IND], str[TEST_IND], str[DATE_IND], str[MARK_IND]);
    }

    @Override
    public boolean hasResult() {
        return scanner.hasNext();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
