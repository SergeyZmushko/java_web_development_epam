package by.epam.lab;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.PriceDiscountPurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.exceptions.CsvLineException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchaseList {
    private final static String NOT_FOUND_TEXT = "File is not found";
    private final static String COMMON = ",";
    private final static String SPACE = " ";
    private final static String SQUARE_BRACKET_HEAD = "[";
    private final static String SQUARE_BRACKET_TAIL = "]";
    private final List<Purchase> purchases = new ArrayList<>();
    private final Comparator<Purchase> comparator;
    private boolean isSorted = false;

    public PurchaseList(String filename, Comparator<Purchase> comparator) {
        this.comparator = comparator;
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                try {
                    purchases.add(PurchaseFactory.getPurchaseFromFactory(str));
                } catch (CsvLineException e) {
                    System.err.println(str);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(NOT_FOUND_TEXT);
        }
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void addElementIntoPos(int position, Purchase purchase) {
        if (position < 0) {
            purchases.add(0, purchase);
        } else if (position <= purchases.size() - 1) {
            purchases.add(position, purchase);
        } else {
            purchases.add(purchase);
        }
        isSorted = false;
    }

    public int deleteSubsequence(int from, int to) {
        if (from < 0 || from > purchases.size() - 1) {
            from = purchases.size() - 1;
        }
        if (to < 0 || to >= purchases.size() - 1) {
            to = 0;
        }
        if (from < to) {
            purchases.subList(from, to).clear();
            return to - from;
        }
        return 0;
    }

    public Byn calculateTotalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase el : purchases) {
            totalCost = totalCost.add(el.getCost());
        }
        return totalCost;
    }

    public String stringRepresentationOfList() {
        StringBuilder result = new StringBuilder();
        result.append(SQUARE_BRACKET_HEAD);
        for (Purchase el : purchases) {
            result.append(el).append(COMMON).append(SPACE);
        }
        result.delete(result.length() - 2, result.length()).append(SQUARE_BRACKET_TAIL);
        return result.toString();
    }

    public void listSort() {
        if (!isSorted) {
            Collections.sort(purchases);
        }
        isSorted = true;
    }

    public int searchElement(Purchase purchase) {
        Collections.sort(purchases);
        isSorted = true;
        return Collections.binarySearch(purchases, purchase);
    }
}
