package by.epam.lab.utils;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;

import static by.epam.lab.utils.Constant.*;

public class PurchaseUtils {
    private Purchase purchase;

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
        System.out.println(COST + purchase.getCost() + BYN);
    }

    public void printCostDiff(Purchase purchase) {
        Byn difference;
        if (this.purchase.getCost().compareTo(purchase.getCost()) == 0) {
            difference = this.purchase.getCost().sub(purchase.getCost());
            System.out.println(DIFF + difference);
        } else if (this.purchase.getCost().compareTo(purchase.getCost()) > 0) {
            difference = this.purchase.getCost().sub(purchase.getCost());
            System.out.println(POSITIVE + DIFF + difference);
        } else if (this.purchase.getCost().compareTo(purchase.getCost()) < 0) {
            difference = this.purchase.getCost().sub(purchase.getCost());
            System.out.println(NEGATIVE + DIFF + difference);
        }
    }

    public void printlsSameCost(Purchase... purchases) {
        boolean result = false;
        for (Purchase purchase1 : purchases) {
            if (purchase1.getCost().compareTo(this.purchase.getCost()) == 0) {
                result = true;
                System.out.println(true);
                System.out.println(purchase1);
            }
        }
        if (!result){
            System.out.println("Purchase is not found");
        }
    }
}
