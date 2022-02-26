package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchaseList {
    private final List<Purchase> purchases = new ArrayList<>();
    private static final String SPLITTER = ";";
    private static final String NOT_FOUND_TEXT = "File is not found";

    public PurchaseList(String filename) {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] element = str.split(SPLITTER);
                try {
                    purchases.add(PurchaseFactory.getPurchaseFromFactory(element));
                } catch (IllegalArgumentException e) {
                    System.err.println(str);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(NOT_FOUND_TEXT);
        }
    }

    public void addElementIntoPos(int position, Purchase purchase) {
        if (position < 0) {
            purchases.add(0, purchase);
        } else if (position <= purchases.size() - 1) {
            purchases.add(position, purchase);
        } else {
            purchases.add(purchase);
        }
    }

    public void deleteSubsequence(int from, int to) {
        if (from < 0 || from > purchases.size() - 1) {
            from = purchases.size() - 1;
        }
        if (to < 0 || to >= purchases.size() - 1) {
            to = 0;
        }
        if (from < to) {
            purchases.subList(from, to).clear();
        }
    }

    public Byn calculateTotalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase el : purchases) {
            totalCost = totalCost.add(el.getTotalCost());
        }
        return totalCost;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public String stringRepresentationOfList() {
        StringBuilder result = new StringBuilder();
        for (Purchase el : purchases) {
            result.append(el);
        }
        return result.toString();
    }

    public void listSort() {
        Collections.sort(purchases);
    }

    public int searchElement(Purchase purchase) {
        Collections.sort(purchases);
        return Collections.binarySearch(purchases, purchase);
    }
}
