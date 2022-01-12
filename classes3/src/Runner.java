import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
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
                purchases[i] = new Purchase(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
        if (purchases.length != 0) {
            System.out.println(Purchase.PRODUCT_NAME + ";" + Utils.fromPennyToByn(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }

        int count = 0;
        int meanCost = 0;
        int totalCostInMonday = 0;
        Purchase purchaseMaxCost = new Purchase();
        for (Purchase purchase : purchases) {
            meanCost += purchase.getCost();
            count++;
            if (purchase.getDay() == 1) {
                totalCostInMonday += purchase.getCost();
            }
            if (purchase.getCost() > purchaseMaxCost.getCost()) {
                purchaseMaxCost = purchase;
            }
        }
        if (count > 0) {
            meanCost = meanCost / count;
        } else {
            meanCost = 0;
        }
        System.out.println("Mean cost = " + Utils.withThreeDigitsAfterThePoint(meanCost));
        System.out.println("The total cost on Monday = " + Utils.fromPennyToByn(totalCostInMonday));
        if (purchases.length != 0) {
            System.out.println("The day with the maximum cost purchase is " + WeekDay.values()[purchaseMaxCost.getDay()]);
        } else {
            System.out.println("The day with the maximum cost purchase is " + null);
        }

        if (purchases.length != 0) {
            Arrays.sort(purchases);
            System.out.println(Purchase.PRODUCT_NAME + "\n" + Utils.fromPennyToByn(Purchase.PRICE));
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }
        }

        int index = Arrays.binarySearch(purchases, new Purchase(5, 0, 0), new Comparator<>() {
            @Override
            public int compare(Purchase o1, Purchase o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        if (index > 0) {
            System.out.println("Purchase with number equalled to 5 - " + purchases[index]);
        } else {
            System.out.println("Required purchase is not found");
        }
    }
}
