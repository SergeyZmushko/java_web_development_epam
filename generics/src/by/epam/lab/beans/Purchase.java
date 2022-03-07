package by.epam.lab.beans;

import by.epam.lab.enums.RoundMethod;
import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Purchase<T extends Priceable, N extends Number> {
    private final T item;
    private final N quantity;

    public Purchase(T item, N quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T getItem() {
        return item;
    }

    public Byn getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + Constant.SEPARATOR + quantity + Constant.SEPARATOR + getCost();
    }
}
