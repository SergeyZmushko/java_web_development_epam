package by.epam.lab.beans;

import static by.epam.lab.utils.Constant.*;

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
        super(fields);
        this.discount = new Byn(Integer.parseInt(fields[DISCOUNT_INDEX]));
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
        return super.fieldToString() + SEPARATOR + discount;
    }

}
