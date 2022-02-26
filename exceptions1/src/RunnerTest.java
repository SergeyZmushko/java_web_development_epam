import by.epam.lab.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RunnerTest {

    private final static String FILENAME = "src/in.csv";

    @Test
    public void testFabricMethod() {
        String[] purchase = {"bread", "155", "1"};
        String[] priceDiscountPurchase = {"potato", "180", "2", "10"};
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
        Purchase priceDiscountPurchaseObj = PurchaseFactory.getPurchaseFromFactory(priceDiscountPurchase);
        assertEquals(new Purchase("bread", "155", "1"), purchaseObj);
        assertEquals(new PriceDiscountPurchase("potato", "180", "2", "10"), priceDiscountPurchaseObj);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFabricMethodExceptionWhenElementsLessRequired() {
        String[] purchase = {"bread", "155"};
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFabricMethodExceptionWhenElementsMoreRequired() {
        String[] purchase = {"bread", "155", "2", "10", "d"};
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
    }

    @Test
    public void testPurchaseListConstructor() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases1 = purchaseList.getPurchases();
        assertEquals(purchasesTest, purchases1);
    }

    @Test
    public void testAddElementIntoRightPos() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.addElementIntoPos(2, new Purchase("butter", "370", "1"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testAddElementIntoPosLesZero() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.addElementIntoPos(-2, new Purchase("butter", "370", "1"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testAddElementIntoPosMoreMaxIndex() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.addElementIntoPos(60, new Purchase("butter", "370", "1"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testCalculateTotalCost() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        Byn totalCost = purchaseList.calculateTotalCost();
        assertEquals(new Byn(4692), totalCost);
    }

    @Test
    public void testDeleteSubsequenceWithCorrectIndexes() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.deleteSubsequence(0, 2);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testDeleteSubsequenceWithIncorrectIndexes() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.deleteSubsequence(-2, 22);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testDeleteSubsequenceWithIncorrectIndexesFromMoreThanTo() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.deleteSubsequence(5, 2);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testGetPurchases() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testListSort() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", "155", "1", "2"));
        purchasesTest.add(new Purchase("milk", "131", "2"));
        purchasesTest.add(new PriceDiscountPurchase("potato", "180", "2", "10"));
        purchasesTest.add(new PriceDiscountPurchase("butter", "341", "1", "1"));
        purchasesTest.add(new Purchase("butter", "370", "1"));
        purchasesTest.add(new Purchase("bread", "154", "3"));
        purchasesTest.add(new Purchase("bread", "145", "5"));
        purchasesTest.add(new PriceDiscountPurchase("meat", "1100", "2", "80"));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.listSort();
        assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testStringRepresentation() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        String listToString = purchaseList.stringRepresentationOfList();
        final String resultString =
                "PriceDiscountPurchase;bread;1.55;1;0.02;1.53" + "Purchase;milk;1.31;2;2.62" +
                        "Purchase;bread;1.54;3;4.62" + "Purchase;bread;1.45;5;7.25" +
                        "PriceDiscountPurchase;potato;1.80;2;0.10;3.40" + "Purchase;butter;3.70;1;3.70" +
                        "PriceDiscountPurchase;butter;3.41;1;0.01;3.40" + "PriceDiscountPurchase;meat;11.00;2;0.80;20.40";
        assertEquals(resultString, listToString);
    }

    @Test
    public void testSearchElement() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        int i = purchaseList.searchElement(new Purchase("milk", "131", "2"));
        assertEquals(1, i);
    }

}