package by.epam.lab.beans;

import static by.epam.lab.utils.Constant.*;

import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(String[] fields) {
        this(fields[NAME_INDEX], new Byn(Integer.parseInt(fields[PRICE_INDEX])),
                Integer.parseInt(fields[NUMBER_INDEX]));
    }

    public Purchase(Scanner sc) {
        this.name = sc.next();
        this.price = new Byn(sc);
        this.number = sc.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldToString() {
        return getClass().getSimpleName() + SEPARATOR + name + SEPARATOR + price +
                SEPARATOR + number;
    }

    @Override
    public String toString() {
        return fieldToString() + SEPARATOR + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        if (!name.equals(purchase.name)) return false;
        return price.equals(purchase.price);
    }

    @Override
    public int hashCode() {
        return PRIME_NUMBER_31 * name.hashCode() + price.hashCode();
    }
}
