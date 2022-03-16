package by.epam.lab.beans;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;

import java.util.Scanner;

public class PricePurchase extends Purchase {
    private Byn discount;

    public PricePurchase() {
        super();
    }

    public PricePurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PricePurchase(String[] fields) {
        this(fields[0], new Byn(Integer.parseInt(fields[1])), Integer.parseInt(fields[2]), new Byn(Integer.parseInt(fields[3])));
    }

    public PricePurchase(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc);
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + discount;
    }

}
