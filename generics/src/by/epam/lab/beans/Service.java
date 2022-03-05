package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.utills.Constant;

public class Service extends Item {
    private final String name;
    private final Byn totalCost;
    private final int numberUsers;

    public Service(String name, Byn totalCost, int numberUsers) {
        this.name = name;
        this.totalCost = totalCost;
        this.numberUsers = numberUsers;
    }

    @Override
    public Byn getCost() {
        return totalCost.divide(numberUsers, RoundMethod.ROUND, 0);
    }

    public String toString() {
        return name + Constant.SEPARATOR + totalCost + Constant.SEPARATOR + numberUsers + Constant.SEPARATOR + getCost();
    }
}
