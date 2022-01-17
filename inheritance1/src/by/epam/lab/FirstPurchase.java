package by.epam.lab;

import java.util.Scanner;

public class FirstPurchase extends Purchase {
    private Byn discount;

    public FirstPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public FirstPurchase(Scanner sc) {
        super(sc);
        this.discount = new Byn(sc.nextInt());
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        return new Byn().sum(getPrice()).difference(discount).multiplication(getNumber());
    }

    @Override
    public String toString() {
        return "FirstPurchase" + ";" + showInfo() + ";" + discount + ";" + getCost();
    }
}
