import by.epam.lab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Purchase[] purchases = new Purchase[6];
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            Purchase purchaseMaxCost = new Purchase(null, new Byn(0), 0);
            int result = 1;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);
                if (purchases[i].getCost().value > purchaseMaxCost.getCost().value) {
                    purchaseMaxCost = purchases[i];
                }
                if (i >= 1) {
                    if (purchases[i].equals(purchases[i - 1])) {
                        result++;
                    }
                }
            }
            if (result == purchases.length) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Purchases are not equal");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
        Byn byn = new Byn(500);
        System.out.println(byn.multiplication(5));
    }

}
