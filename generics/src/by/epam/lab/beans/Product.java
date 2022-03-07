package by.epam.lab.beans;

import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.Constant;

public class Product implements Priceable {
    private final String name;
    private final Byn price;

    public Product(String name, Byn price) {
        this.name = name;
        this.price = price;
    }

    public Byn getPrice() {
        return price;
    }

    public String fieldsToString(){
        return getClass().getSimpleName() + Constant.SEPARATOR + name + Constant.SEPARATOR + price;
    }

    @Override
    public String toString() {
        return fieldsToString() + Constant.SEPARATOR + getPrice();
    }
}
