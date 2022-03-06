package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Purchase<T1 extends Priceable, T2 extends Number> implements Comparable<Purchase<Priceable, Number>> {
    private T1 item;
    private T2 quantity;

    public Purchase(T1 item, T2 quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T1 getItem() {
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
