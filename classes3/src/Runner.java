import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import by.epam.lab.WeekDay;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Purchase[] purchases;
        try (Scanner sc = new Scanner(new FileReader("src/in1.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = new Purchase(
                        sc.nextInt(),
                        sc.nextDouble(),
                        WeekDay.values()[sc.nextInt()]);
            }
            printPurchases(purchases);
            int totalCost = 0;
            int totalCostMonday = 0;
            int maxCost = 0;
            double meanCost = 0.0;
            WeekDay maxCostDay = null;
            for (Purchase purchase : purchases) {
                int cost = purchase.getCost();
                totalCost += cost;
                if (purchase.getDay() == WeekDay.MONDAY) {
                    totalCostMonday += cost;
                }
                if (cost > maxCost) {
                    maxCost = cost;
                    maxCostDay = purchase.getDay();
                }
            }
            if (purchases.length > 0) {
                meanCost = (double) totalCost / purchases.length / 100;
            }
            System.out.printf("Mean cost = %.3f \n", meanCost);
            System.out.println("The total cost on Monday = " + Utils.fromPennyToByn(totalCostMonday));
            System.out.println("The day with the maximum cost purchase is " + maxCostDay);
            Arrays.sort(purchases);
            printPurchases(purchases);
            int index = Arrays.binarySearch(purchases, new Purchase(5, 0, WeekDay.MONDAY));
            if (index >= 0) {
                System.out.println("Purchase with number equalled to 5 - " + purchases[index]);
            } else {
                System.out.println("Required purchase is not found");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }

    private static void printPurchases(Purchase[] purchases) {
        if (purchases.length != 0) {
            System.out.println(Purchase.PRODUCT_NAME + ";" + Utils.fromPennyToByn(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }
    }
}
