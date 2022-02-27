package by.epam.lab.services;

import by.epam.lab.beans.Byn;
import by.epam.lab.beans.Purchase;
import by.epam.lab.exceptions.CsvLineException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchaseList {
    private final static String NOT_FOUND_TEXT = "File is not found";
    private final static String COMMON = ", ";
    private final static String SQUARE_BRACKET_HEAD = "[";
    private final static String SQUARE_BRACKET_TAIL = "]";
    private final List<Purchase> purchases = new ArrayList<>();
    private final Comparator<Purchase> comparator;
    private boolean isSorted = false;

    public PurchaseList(String filename, Comparator<Purchase> comparator) {
        this.comparator = comparator;
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                try {
                    purchases.add(PurchaseFactory.getPurchaseFromFactory(sc.nextLine()));
                } catch (CsvLineException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(NOT_FOUND_TEXT);
            isSorted = true;
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
        int startSize = purchases.size();
        if (from > to) {
            return 0;
        }
        from = Math.max(from, 0);
        to = Math.min(to, purchases.size() - 1);
        purchases.subList(from, to).clear();
        return startSize - purchases.size();
    }

    public Byn calculateTotalCost() {
        Byn totalCost = new Byn(0);
        for (Purchase el : purchases) {
            totalCost = totalCost.add(el.getCost());
        }
        return totalCost;
    }

    public String stringRepresentationOfList() {
        int lengthForDelete = 2;
        StringBuilder result = new StringBuilder();
        result.append(SQUARE_BRACKET_HEAD);
        for (Purchase el : purchases) {
            result.append(el).append(COMMON);
        }
        result.delete(result.length() - lengthForDelete, result.length()).append(SQUARE_BRACKET_TAIL);
        return result.toString();
    }

    public void listSort() {
        if (!isSorted) {
            purchases.sort(comparator);
        }
        isSorted = true;
    }

    public int searchElement(Purchase purchase) {
        if (!isSorted) {
            purchases.sort(comparator);
        }
        isSorted = true;
        return Collections.binarySearch(purchases, purchase, comparator);
    }
}
