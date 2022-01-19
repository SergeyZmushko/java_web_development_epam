package by.epam.lab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private final static int COUNT = 10;
    private double percent;

    public PercentDiscountPurchase() {
        super();
    }

    public PercentDiscountPurchase(String name, Byn price, int number, double percent) {
        super(name, price, number);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.percent = sc.nextDouble();
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public Byn getCost() {
        Byn byn = super.getCost();
        if (getNumber() > COUNT) {
            byn.mul(1 - percent / 100);
        }
        return byn;
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + percent;
    }
}
