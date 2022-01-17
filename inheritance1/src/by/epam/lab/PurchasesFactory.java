package by.epam.lab;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE,
        FIRST_PURCHASE,
        SECOND_PURCHASE
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case FIRST_PURCHASE:
                return new FirstPurchase(sc);
            case SECOND_PURCHASE:
                return new SecondPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
