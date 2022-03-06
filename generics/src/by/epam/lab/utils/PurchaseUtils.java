package by.epam.lab.utils;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;
import by.epam.lab.implement.Priceable;

import static by.epam.lab.utils.Constant.*;

public class PurchaseUtils<T extends Priceable, N extends Number> {
    private Purchase<T, N> purchase;

    public PurchaseUtils(Purchase<T, N> purchase) {
        this.purchase = purchase;
    }

    public Purchase<T, N> getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println(COST + purchase.getCost() + BYN);
    }

    public <E extends Purchase<? extends Priceable, ? extends Number>> void printCostDiff(E p) {
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

    @SafeVarargs
    public final <E extends Purchase<? extends Priceable, ? extends Number>> void printSameCost(E... purchases) {
        boolean result = false;
        for (E purchase : purchases) {
            if (purchase.getCost().compareTo(this.purchase.getCost()) == 0) {
                result = true;
                break;
            }
        }
        System.out.println(result ? PURCHASE_WITH_SAME_COST : PURCHASE_IS_NOT_FOUND);
    }
}
