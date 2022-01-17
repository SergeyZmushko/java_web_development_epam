package by.epam.lab;

import java.util.Scanner;

public class SecondPurchase extends Purchase {
    private final static int COUNT = 10;
    private double discountPercent;

    public SecondPurchase(String name, Byn price, int number, double discountPercent) {
        super(name, price, number);
        this.discountPercent = discountPercent;
    }

    public SecondPurchase(Scanner sc) {
        super(sc.next(), new Byn(sc.nextInt()), sc.nextInt());
        this.discountPercent = sc.nextDouble();
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public int getCost() {
        if (getNumber() > COUNT) {
            return (int) Math.round(super.getNumber() * super.getPrice().value *
                    (1 - discountPercent / 100));
        } else {
            return super.getCost();
        }
    }

    @Override
    public String toString() {
        return "SecondPurchase" + ";" + getName() + ";" + getPrice() + ";" +
                getNumber() + ";" + discountPercent + ";" + Utils.fromPennyToByn(getCost());
    }
}
