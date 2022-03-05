package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.utils.Constant;

public class Purchase {
    private final Item item;
    private final Number count;

    public Purchase(Item item, Number count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public Number getCount() {
        return count;
    }

    public Byn getPurchaseCost() {
        return item.getCost().mul(count.doubleValue(), RoundMethod.ROUND, 0);
    }

    public String toString() {
        return getClass().getSimpleName() + Constant.SEPARATOR + item + Constant.SEPARATOR + count + Constant.SEPARATOR
                + getPurchaseCost();
    }
}
