package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Purchase implements Comparable<Purchase> {
    private Priceable item;
    private final Number quantity;

    public Purchase(Priceable item, Number quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Priceable getItem() {
        return item;
    }

    public Byn getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    public String toString() {
        return getClass().getSimpleName() + Constant.SEPARATOR + item + Constant.SEPARATOR + quantity
                + Constant.SEPARATOR + getCost();
    }

    @Override
    public int compareTo(Purchase o) {
        return getCost().compareTo(o.getCost());
    }
}
