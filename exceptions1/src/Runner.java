
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseList;

import java.util.List;


public class Runner {
    public static void main(String[] args) {
        PurchaseList purchaseList = new PurchaseList("src/in.csv");
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.stringRepresentationOfList(purchases);
        List<Purchase> purchases1 = purchaseList.deletingSubsequence(purchases, 2, 4);
        System.out.println("After deleting");
        purchaseList.stringRepresentationOfList(purchases1);
//        purchaseList.stringRepresentationOfList(purchaseList.getPurchases());
//        System.out.println(purchaseList.getPurchases().size());
//        purchaseList.deletingSubsequence(purchaseList.getPurchases(), 8, 9);
//        System.out.println("after deleting");

    }
}
