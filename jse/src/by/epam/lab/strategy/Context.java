package by.epam.lab.strategy;

import by.epam.lab.bean.Test;

import java.sql.SQLException;
import java.util.LinkedList;

public class Context {
    Config strategy;

    public void setStrategy(Config strategy) {
        this.strategy = strategy;
    }

    public void executeActivity(String filename) throws SQLException, ClassNotFoundException {
        strategy.fillDb(filename);
        strategy.printMeanMarks();
        LinkedList<Test> tests = strategy.currentMonthResults();
        strategy.printList(tests);
        strategy.printLastDayResult(tests);
    }
}
