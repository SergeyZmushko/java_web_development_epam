package by.epam.lab.strategy;

import by.epam.lab.bean.Test;
import by.epam.lab.dbConnection.Db;
import by.epam.lab.strategy.impl.DbStrategy;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public abstract class Config implements DbStrategy {
    Db db = new Db();

    @Override
    public abstract void fillDb(String filename) throws SQLException, ClassNotFoundException;

    @Override
    public void printMeanMarks() throws SQLException, ClassNotFoundException {
        db.printMeanMark();
    }

    @Override
    public void printLastDayResult(LinkedList<Test> tests) {
        db.printLatestDayResult(tests);
    }

    @Override
    public LinkedList<Test> currentMonthResults() throws SQLException, ClassNotFoundException {
        return db.getSortedDateList();
    }

    @Override
    public void printList(List<Test> tests) {
        db.printList(tests);
    }
}
