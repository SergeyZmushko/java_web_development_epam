import by.epam.lab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final int PURCHASE_NUMBER = 6;
        Purchase[] purchases = new Purchase[PURCHASE_NUMBER];
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            Purchase purchaseMaxCost = new Purchase(null, new Byn(0), 0);
            int result = 1;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().compareTo(purchaseMaxCost.getCost()) > 0) {
                    purchaseMaxCost = purchases[i];
                }
                if (i >= 1) {
                    if (purchases[i].equals(purchases[i - 1])) {
                        result++;
                    }
                }
            }
            System.out.println("Purchase with maximum cost is " + purchaseMaxCost);
            if (result == purchases.length) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Purchases are not equal");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
