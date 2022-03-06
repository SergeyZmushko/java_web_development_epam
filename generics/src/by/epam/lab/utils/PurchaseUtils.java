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
        String difPurchase = EMPTY_STRING;
        Byn costDiff = new Byn(0);
        Byn cost1 = purchase.getCost();
        Byn cost2 = p.getCost();
        int result = cost1.compareTo(cost2);
        if (result > 0) {
            costDiff = cost1.sub(cost2);
            difPurchase = POSITIVE;
        }
        if (result < 0) {
            costDiff = cost2.sub(cost1);
            difPurchase = NEGATIVE;

        }
        System.out.println(difPurchase + DIFF + costDiff);

    }

    public void printSameCost(Purchase... purchases) {
        boolean result = false;
        for (Purchase purchase : purchases) {
            if (purchase.getCost().compareTo(this.purchase.getCost()) == 0) {
                result = true;
                break;
            }
        }
        System.out.println(result ? PURCHASE_WITH_SAME_COST : PURCHASE_IS_NOT_FOUND);
    }
}
