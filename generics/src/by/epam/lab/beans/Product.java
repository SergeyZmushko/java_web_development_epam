package by.epam.lab.beans;

import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Product implements Priceable {
    private String name;
    private Byn price;

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Byn getPrice() {
        return price;
    }

    public String toString() {
        return name + Constant.SEPARATOR + price + Constant.SEPARATOR + getPrice();
    }
}
