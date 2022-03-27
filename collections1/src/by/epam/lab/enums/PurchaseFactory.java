package by.epam.lab.enums;

import by.epam.lab.beans.PricePurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.utils.Constant;

public class PurchaseFactory {

    private enum PurchaseKind {
        GENERAL_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new Purchase(fields);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            public Purchase getPurchase(String[] fields) {
                return new PricePurchase(fields);
            }
        };

        abstract protected Purchase getPurchase(String[] fields);
    }

    private static PurchaseKind getPurchaseKind(int length) {
        return PurchaseKind.values()[length - Constant.INDEX_DIFFERENCE];
    }

    public static Purchase getPurchaseFromFactory(String csvLine) {
        String[] fields = csvLine.split(Constant.SEPARATOR);
        return getPurchaseKind(fields.length).getPurchase(fields);
    }
}

