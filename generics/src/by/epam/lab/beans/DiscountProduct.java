package by.epam.lab.beans;

import by.epam.lab.utils.Constant;

public class DiscountProduct extends Product {
    private final Byn discount;

    public DiscountProduct(String name, Byn price, Byn discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return getPrice().sub(discount);
    }

    @Override
    public String toString() {
        return super.toString() + Constant.SEPARATOR + discount;
    }
}
