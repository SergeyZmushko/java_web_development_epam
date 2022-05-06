package by.epam.lab;

import by.epam.lab.bean.Result;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import static by.epam.lab.util.Constants.*;

public class ResultImplCsv implements ResultDao{
    private Scanner scanner;

    public ResultImplCsv(String fileName) {
        try {
            scanner = new Scanner(new FileReader(fileName));
        }catch (FileNotFoundException e){
            System.out.println(FILE_NOT_FOUND);
        }
    }

    @Override
    public Result nextResult() {
       String[] str = scanner.next().split(";");
       return new Result(str[0], str[1], str[2], str[3]);
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
