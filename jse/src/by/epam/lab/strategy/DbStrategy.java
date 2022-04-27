package by.epam.lab.strategy;

import by.epam.lab.bean.Test;

import java.sql.SQLException;
import java.util.List;

public interface DbStrategy {
    void fillDb(String filename) throws SQLException, ClassNotFoundException;
    void printMeanMarks() throws SQLException, ClassNotFoundException;
    void printLastDayResult(List<? extends Test> tests) throws SQLException, ClassNotFoundException;
    void printList(List<? extends Test> tests);
}