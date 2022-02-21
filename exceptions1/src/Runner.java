
import by.epam.lab.Byn;
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseList;

import java.util.List;


public class Runner {
    public static void main(String[] args) {
        PurchaseList purchaseList = new PurchaseList("src/in.csv");
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.stringRepresentationOfList(purchases);
        purchaseList.deletingSubsequence(purchases, 0, 5);
        System.out.println("After deleting");
        purchaseList.stringRepresentationOfList(purchases);
        Byn totalCost = purchaseList.calculateTotalCost(purchases);
        System.out.println(totalCost);
        purchaseList.listSort(purchases);
        purchaseList.stringRepresentationOfList(purchases);
 //       System.out.println(purchaseList.searchElement(purchases, new Purchase("butter", new Byn(370), 1)));

    }
}
