package by.epam.lab;

import by.epam.lab.bean.Result;

import java.io.IOException;

public class ResultImplXml implements ResultDao{

    @Override
    public Result nextResult() {
        return null;
    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
