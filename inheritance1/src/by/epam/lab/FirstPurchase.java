package by.epam.lab;

import java.util.Scanner;

public class FirstPurchase extends Purchase {
    private double discount;

    public FirstPurchase(String name, Byn price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public FirstPurchase(Scanner sc) {
        super(sc.next(), new Byn(sc.nextInt()), sc.nextInt());
        this.discount = sc.nextDouble();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        Byn byn = new Byn(getPrice().value);
        return byn.difference(discount).multiplication(getNumber());
    }

    @Override
    public String toString() {
        return "FirstPurchase" + ";" + getName() + ";" + getPrice() + ";" +
                getNumber() + ";" + discount + ";" + Utils.fromPennyToByn(getCost().value);
    }
}
