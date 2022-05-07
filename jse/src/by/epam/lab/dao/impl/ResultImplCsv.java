package by.epam.lab.dao.impl;

import by.epam.lab.bean.Result;
import by.epam.lab.dao.ResultDao;
import by.epam.lab.factory.HalfResultFactory;
import by.epam.lab.factory.ResultFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.lab.util.Constants.*;

public class ResultImplCsv implements ResultDao {
    private Scanner scanner;

    public ResultImplCsv(String fileName) {
        try {
            scanner = new Scanner(new FileReader(fileName));
        }catch (FileNotFoundException e){
            System.out.println(FILE_NOT_FOUND);
            System.out.println(e);
        }
    }

    @Override
    public Result nextResult() {
       String[] str = scanner.next().split(";");
        Pattern pattern = Pattern.compile("\\d\\.\\d");
        Matcher matcher = pattern.matcher(str[3]);
        if (matcher.matches()){
            return new ResultFactory().getResultFromFactory(str[0], str[1], Date.valueOf(str[2]), Integer.parseInt(str[3]));
        }else {
            return new HalfResultFactory().getResultFromFactory(str[0], str[1], Date.valueOf(str[2]), Double.parseDouble(str[3]));
        }
    }

    @Override
    public boolean hasResult() {
        return scanner.hasNext();
    }

    @Override
    public void close()  {
        scanner.close();
    }
}
