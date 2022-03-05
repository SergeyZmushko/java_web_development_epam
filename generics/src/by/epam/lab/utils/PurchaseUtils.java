package by.epam.lab.utils;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;

import static by.epam.lab.utils.Constant.*;

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
        int i = 0;
        for (Purchase purchase1 : purchases) {
            if (purchase1.getPurchaseCost().compareTo(this.purchase.getPurchaseCost()) == 0) {
                System.out.println(TRUE);
                System.out.println(purchase1);
                i++;
            }
        }
        if (i == 0){
            System.out.println("Purchase is not found");
        }
    }
}
