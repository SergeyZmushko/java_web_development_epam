package by.epam.lab;

public class PurchaseFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(String[] elements) {
                return new Purchase(elements);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            Purchase getPurchase(String[] elements) {
                return new PriceDiscountPurchase(elements);
            }
        };

        abstract Purchase getPurchase(String[] elements);
    }

    public static Purchase getPurchaseFromFactory(String[] elements) {
        PurchaseKind purchaseKind;
        if (elements.length == 3 || elements.length == 4) {
            purchaseKind = PurchaseKind.values()[elements.length - 3];
        } else {
            throw new IllegalArgumentException();
        }
        return purchaseKind.getPurchase(elements);
    }
}
