package by.epam.lab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class PurchaseList {
    private List<Purchase> purchases = new ArrayList<>();
    private static final String SPLITER = ";";

    public PurchaseList(String filename) {
        try (Scanner sc = new Scanner(new FileReader(filename))) {
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] element = str.split(SPLITER);
                try {
                    purchases.add(PurchaseFactory.getPurchaseFromFactory(element));
                } catch (IllegalArgumentException | NullPointerException e) {
                    System.err.println(str);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found");
        }
    }

    public void addElementIntoPos(int position, Purchase purchase, List<Purchase> purchases) {
        if (position <= purchases.size() - 1) {
            purchases.add(position, purchase);
        } else {
            purchases.add(purchase);
        }
    }

    //если from и to за пределами массива, как обработать?
    public void deletingSubsequence(List<Purchase> purchases, int from, int to) throws IllegalArgumentException {
        if (from < 0 || from > purchases.size() - 1) {
            throw new IllegalArgumentException();
        }
        if (to <= 0 || to > purchases.size() - 1) {
            throw new IllegalArgumentException();
        }
        purchases.subList(from, to).clear();
    }

    public Byn calculateTotalCost(List<Purchase> purchases) {
        Byn totalCost = new Byn(0);
        for (Purchase el : purchases) {
            totalCost.add(el.getTotalCost());
        }
        return totalCost;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void stringRepresentationOfList(List<Purchase> purchases) {
        for (Purchase el : purchases) {
            System.out.println(el);
        }
    }

    public void listSort (List<Purchase> purchases){
        Collections.sort(purchases);
    }

    public Purchase searchElement(List<Purchase> purchases, Purchase purchase) throws IllegalArgumentException{
        int index = Collections.binarySearch(purchases, purchase);
        if (!purchases.isEmpty() && index >=0 && index < purchases.size()){
            return purchases.get(index);
        }
        throw new IllegalArgumentException();
    }


}
