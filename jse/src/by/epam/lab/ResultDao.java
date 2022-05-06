package by.epam.lab;

import by.epam.lab.bean.Result;

import java.io.Closeable;

public interface ResultDao extends Closeable {
    Result nextResult();
    boolean hasResult();
}
