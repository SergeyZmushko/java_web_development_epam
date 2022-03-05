package by.epam.lab;

import static by.epam.lab.Constant.*;

public class PurchaseUtils {
    private Purchase purchase;

    public PurchaseUtils() {
    }

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(COST + purchase.getPurchaseCost() + BYN);
    }

    public void printCostDiff(Purchase purchase) {
        Byn difference;
        if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) == 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(DIFFERENCE + difference);
        } else if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) > 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(POSITIVE + DIFFERENCE + difference);
        } else if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) < 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(NEGATIVE + DIFFERENCE + difference);
        }
    }

    public void printlsSameCost(Purchase... purchases) {
        for (Purchase purchase1 : purchases) {
            if (purchase1.getPurchaseCost().compareTo(this.purchase.getPurchaseCost()) == 0) {
                System.out.println(TRUE);
                System.out.println(purchase1);
            }
        }
    }
}
