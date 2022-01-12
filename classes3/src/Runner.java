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
        Purchase[] purchases = new Purchase[0];
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();
            purchases = new Purchase[PURCHASES_NUMBER];
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = new Purchase(
                        sc.nextInt(),
                        sc.nextInt(),
                        WeekDay.values()[sc.nextInt()]);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }

        printArrayToConsole(purchases);

        int count = 0;
        double meanCost = 0.0;
        int totalCostInMonday = 0;
        Purchase purchaseMaxCost = new Purchase();
        for (Purchase purchase : purchases) {
            meanCost += purchase.getCost();
            count++;
            if (purchase.getDay().equals(WeekDay.MONDAY)) {
                totalCostInMonday += purchase.getCost();
            }
            if (purchase.getCost() > purchaseMaxCost.getCost()) {
                purchaseMaxCost = purchase;
            }
        }
        if (count > 0) {
            meanCost = meanCost / count / 100;
        } else {
            meanCost = 0.0;
        }
        System.out.printf("Mean cost = %.3f \n", meanCost);
        System.out.println("The total cost on Monday = " + Utils.fromPennyToByn(totalCostInMonday));
        if (purchases.length != 0) {
            System.out.println("The day with the maximum cost purchase is " + purchaseMaxCost.getDay());
        } else {
            System.out.println("The day with the maximum cost purchase is " + null);
        }

        Arrays.sort(purchases);
        printArrayToConsole(purchases);

        int index = Arrays.binarySearch(purchases, new Purchase(5, 0, WeekDay.MONDAY));
        if (index >= 0) {
            System.out.println("Purchase with number equalled to 5 - " + purchases[index]);
        } else {
            System.out.println("Required purchase is not found");
        }
    }

    private static void printArrayToConsole(Purchase[] purchases) {
        if (purchases.length != 0) {
            System.out.println(Purchase.PRODUCT_NAME + ";" + Utils.fromPennyToByn(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }
    }
}
