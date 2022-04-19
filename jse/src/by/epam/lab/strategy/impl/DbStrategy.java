package by.epam.lab.strategy.impl;

import by.epam.lab.bean.Test;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public interface DbStrategy {
    void fillDb(String filename) throws SQLException, ClassNotFoundException;
    void printMeanMarks() throws SQLException, ClassNotFoundException;
    void printLastDayResult(LinkedList<Test> tests) throws SQLException, ClassNotFoundException;
    LinkedList<Test> currentMonthResults() throws SQLException, ClassNotFoundException;
    void printList(List<Test> tests);
}
