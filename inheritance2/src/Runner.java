import by.epam.lab.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Product product = new Product("Bike", new Byn(100));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 5, new Byn(0)),
                new PriceDiscountPurchase(product, 9, new Byn(20)),
                new PercentDiscountPurchase(product, 7, 5.6),
                new PercentDiscountPurchase(product, 15, 45.6),
                new TransportExpensesPurchase(product, 5, new Byn(30)),
                new TransportExpensesPurchase(product, 4, new Byn(20))
        };
        printArray(purchases);
        Arrays.sort(purchases);
        printArray(purchases);
        System.out.println("Minimum cost = " + purchases[purchases.length - 1].getCost());
        int index = search(purchases, new PriceDiscountPurchase(new Product("Bike", new Byn(100)), 5, new Byn(0)));
        if (index >= 0) {
            System.out.println(purchases[index]);
        } else {
            System.out.println("Required purchase is not found");
        }
    }

    private static void printArray(AbstractPurchase[] abstractPurchases) {
        for (AbstractPurchase abstractPurchase : abstractPurchases) {
            System.out.println(abstractPurchase);
        }
    }

    private static int search(AbstractPurchase[] purchases, AbstractPurchase purchase) {
        return Arrays.binarySearch(purchases, purchase);
    }
}
