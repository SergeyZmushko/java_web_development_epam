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
        Purchase purchase = null;
        if (elements.length == 3) {
            purchase =  PurchaseKind.GENERAL_PURCHASE.getPurchase(elements);
        } else if (elements.length == 4) {
            purchase = PurchaseKind.PRICE_DISCOUNT_PURCHASE.getPurchase(elements);
        }
        return purchase;
    }
}
