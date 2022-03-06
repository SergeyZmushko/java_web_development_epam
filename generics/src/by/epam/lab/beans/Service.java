package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Service implements Priceable {
    private final String name;
    private final Byn totalCost;
    private final int numberOfUsers;

    public Service(String name, Byn totalCost, int numberOfUsers) {
        this.name = name;
        this.totalCost = totalCost;
        this.numberOfUsers = numberOfUsers;
    }

    public Byn getPrice() {
        return totalCost.mul(1.0 / numberOfUsers, RoundMethod.CEIL, 0);
    }

    public String toString() {
        return name + Constant.SEPARATOR + totalCost + Constant.SEPARATOR + numberOfUsers
                + Constant.SEPARATOR + getPrice();
    }
}
