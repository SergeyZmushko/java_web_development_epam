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

    public void printCostDiff(Purchase p) {
        Byn costDiff;
        int result = purchase.compareTo(p);
        if (result > 0){
            costDiff = purchase.getCost().sub(p.getCost());
            System.out.println(POSITIVE + DIFF + costDiff);
        }
        if(result < 0){
            costDiff = p.getCost().sub(purchase.getCost());
            System.out.println(NEGATIVE + DIFF + costDiff);

        }
        if (result == 0){
            costDiff = p.getCost().sub(purchase.getCost());
            System.out.println(EMPTY_STRING + DIFF + costDiff);
        }
    }

    public void printSameCost(Purchase ... p) {
        boolean result = false;
        for (Purchase purchase : p) {
            if (purchase.compareTo(this.purchase) == 0) {
                result = true;
                System.out.println(purchase);
            }
        }
        if (!result){
            System.out.println("Purchase is not found");
        }
    }
}
