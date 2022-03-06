package by.epam.lab.utils;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;
import by.epam.lab.implement.Priceable;

import static by.epam.lab.utils.Constant.*;

public class PurchaseUtils<T1 extends Purchase<? extends Priceable, ? extends Number>> {
    private T1 purchase;

    public PurchaseUtils(T1 purchase) {
        this.purchase = purchase;
    }

    public T1 getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(COST + purchase.getCost() + BYN);
    }

    public <T5 extends Purchase<? extends Priceable, ? extends Number>> void printCostDiff(T5 p) {
        Byn costDiff;
        int result = purchase.compareTo(p);
        if (result > 0) {
            costDiff = purchase.getCost().sub(p.getCost());
            System.out.println(POSITIVE + DIFF + costDiff);
        }
        if (result < 0) {
            costDiff = p.getCost().sub(purchase.getCost());
            System.out.println(NEGATIVE + DIFF + costDiff);

        }
        if (result == 0) {
            costDiff = p.getCost().sub(purchase.getCost());
            System.out.println(EMPTY_STRING + DIFF + costDiff);
        }
    }


    @SafeVarargs
    public final <T4 extends Purchase<? extends Priceable, ? extends Number>> void printSameCost(T4... purchases) {
        boolean result = false;
        for (T4 purchase : purchases) {
            if (purchase.compareTo(this.purchase) == 0) {
                result = true;
                System.out.println(purchase);
            }
        }
        if (!result) {
            System.out.println("Purchase is not found");
        }
    }
}
