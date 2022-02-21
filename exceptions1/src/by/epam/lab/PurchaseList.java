package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PurchaseList {
    private List<Purchase> purchases;
    private static final String SPLITER = ";";

    public PurchaseList(String filename) {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            purchases = new ArrayList<>();
            while (sc.hasNextLine()) {
                String[] element = sc.nextLine().split(SPLITER);
                try {
                    purchases.add(PurchaseFactory.getPurchaseFromFactory(element));
                    System.out.println(PurchaseFactory.getPurchaseFromFactory(element));
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            purchases = new ArrayList<>();
        }
    }

    public void addElementIntoPos(int position, Purchase purchase, List<Purchase> purchases) {
        if (position <= purchases.size() - 1) {
            purchases.add(position, purchase);
        } else {
            purchases.add(purchase);
        }
    }

    //todo
    public void deletingSubsequence(List<Purchase> purchases, int from, int to) {
        if (from < 0 || from > purchases.size() - 1) {
            from = 0;
        }
        if (to <= 0 || to > purchases.size() - 1) {
            to = purchases.size() - 1;
        }
        purchases.subList(from, to).clear();
    }

    public Byn calculateTotalCost(List<Purchase> purchases) {
        Byn totalCost = new Byn(0);
        for (Purchase el : purchases) {
            totalCost.add(el.getCost());
        }
        return totalCost;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void stringRepresentationOfList(List<Purchase> purchases) {
        for (Purchase el : purchases) {
            System.out.println(el + ";");
        }
    }
// todo сортировка по итератору
//    public void sortList(List<Purchase> purchases){
//        purchases.sort();
//    }


}
