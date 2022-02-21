package by.epam.lab;

public class PurchaseFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            Purchase getPurchase(String[] elements) throws IllegalArgumentException {
                return new Purchase(elements);
            }
        },
        PRICE_DISCOUNT_PURCHASE {
            Purchase getPurchase(String[] elements) throws IllegalArgumentException {
                return new PriceDiscountPurchase(elements);
            }
        };

        abstract Purchase getPurchase(String[] elements);
    }

    public static Purchase getPurchaseFromFactory(String[] elements) throws IllegalArgumentException{
        Purchase purchase;
        if (elements.length == 3) {
            purchase = PurchaseKind.GENERAL_PURCHASE.getPurchase(elements);
        } else if (elements.length == 4) {
            purchase = PurchaseKind.PRICE_DISCOUNT_PURCHASE.getPurchase(elements);
        }else{
            throw new IllegalArgumentException();
        }
        return purchase;
    }
}
