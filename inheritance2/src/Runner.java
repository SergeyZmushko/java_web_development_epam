import by.epam.lab.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Product product = new Product("Bike", new Byn(128369));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 4, new Byn(3000)),
                new PriceDiscountPurchase(product, 9, new Byn(8900)),
                new PercentDiscountPurchase(product, 7, 5.6),
                new PercentDiscountPurchase(product, 15, 25.5),
                new TransportExpensesPurchase(product, 5, new Byn(3000)),
                new TransportExpensesPurchase(product, 4, new Byn(1000))
        };
        printArray(purchases);
        Arrays.sort(purchases);
        printArray(purchases);
        System.out.println("Minimum cost = " + purchases[purchases.length - 1].getCost());
        int index = search(purchases, new PriceDiscountPurchase(new Product("Milk", new Byn(128369)), 0, new Byn(0)));
        if(index >= 0){
            System.out.println(purchases[index]);
        }else{
            System.out.println("Required purchase is not found");
        }

    }
    private static void printArray(AbstractPurchase[] abstractPurchases){
        for (AbstractPurchase abstractPurchase : abstractPurchases){
            System.out.println(abstractPurchase);
        }
    }
    private static int search (AbstractPurchase[] purchases, AbstractPurchase purchase){
        return Arrays.binarySearch(purchases, purchase);
    }
}
