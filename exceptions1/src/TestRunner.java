import by.epam.lab.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    private final static String FILENAME = "src/in.csv";

    @Test
    public void testFabricMethod() {
        String[] purchase = {"bread", "155", "1"};
        String[] priceDiscountPurchase = {"potato", "180", "2", "10"};
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
        Purchase priceDiscountPurchaseObj = PurchaseFactory.getPurchaseFromFactory(priceDiscountPurchase);
        Assert.assertEquals(new Purchase("bread", "155", "1"), purchaseObj);
        Assert.assertEquals(new PriceDiscountPurchase("potato", "180", "2", "10"), priceDiscountPurchaseObj);
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
        Assert.assertEquals(purchasesTest, purchases1);
    }

    @Test
    public void testAddElIntoPos() {
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
        Assert.assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testCalculateTotalCost() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        Byn totalCost = purchaseList.calculateTotalCost();
        Assert.assertEquals(new Byn(4692), totalCost);
    }

    @Test
    public void testDeleteSubsequence() {
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
        Assert.assertEquals(purchasesTest, purchases);
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
        Assert.assertEquals(purchasesTest, purchases);
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
        Assert.assertEquals(purchasesTest, purchases);
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
        Assert.assertEquals(resultString, listToString);
    }

    @Test
    public void testSearchElement() {
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        int i = purchaseList.searchElement(new Purchase("milk", "131", "2"));
        Assert.assertEquals(1, i);
    }


}