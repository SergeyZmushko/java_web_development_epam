package by.epam.lab.beans;

import by.epam.lab.utils.Constant;

public class Product extends Item {
    private final String name;
    private final Byn price;

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public Byn getCost() {
        return price;
    }

    public String toString() {
        return name + Constant.SEPARATOR + price;
    }
}
