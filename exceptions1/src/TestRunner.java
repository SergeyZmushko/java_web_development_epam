import by.epam.lab.Byn;
import by.epam.lab.PriceDiscountPurchase;
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    @Test
    public void testFabricMethod(){
        String[] purchase = {"bread","155","1"};
        String[] priceDiscountPurchase = {"potato","180","2","10"};
        Purchase purchaseObj = new Purchase(purchase);
        Purchase priceDiscountPurchaseObj = new Purchase(priceDiscountPurchase);
        Assert.assertEquals(new Purchase("bread",new Byn(155),1), purchaseObj);
        Assert.assertEquals(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)), priceDiscountPurchaseObj);
    }

    @Test
    public void testPurchaseListConstructor(){
        final String FILENAME = "src/in.csv";
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases1 = purchaseList.getPurchases();
        Assert.assertEquals(purchasesTest, purchases1);
    }

    @Test
    public void testAddElIntoPos(){
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        final String FILENAME = "src/in.csv";
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.addElementIntoPos(2, new Purchase("butter", new Byn(370), 1), purchases);
        Assert.assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testCalculateTotalCost(){
        final String FILENAME = "src/in.csv";
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        Byn totalCost = purchaseList.calculateTotalCost(purchases);
        Assert.assertEquals(new Byn(4692), totalCost);
    }

    @Test
    public void testDeleteSubsequence(){
        final String FILENAME = "src/in.csv";
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchases.add(new Purchase("milk", new Byn(131), 2));
        purchases.add(new Purchase("bread", new Byn(154), 3));
        purchases.add(new Purchase("bread", new Byn(145), 5));
        purchaseList.deleteSubsequence(purchases, 0, 2);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        Assert.assertEquals(purchasesTest, purchases);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteSubsequenceException(){
        final String FILENAME = "src/in.csv";
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchases.add(new Purchase("milk", new Byn(131), 2));
        purchases.add(new Purchase("bread", new Byn(154), 3));
        purchases.add(new Purchase("bread", new Byn(145), 5));
        purchaseList.deleteSubsequence(purchases, 0, 12);
    }

    @Test
    public void testGetPurchases(){
        final String FILENAME = "src/in.csv";
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        Assert.assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testListSort(){
        final String FILENAME = "src/in.csv";
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        purchaseList.listSort(purchases);
        Assert.assertEquals(purchasesTest, purchases);
    }

    @Test
    public void testStringRepresentation(){
        final String FILENAME = "src/in.csv";
        PurchaseList purchaseList = new PurchaseList(FILENAME);
        List<Purchase> purchases = purchaseList.getPurchases();
        final String RESULT_STRING = """
                PriceDiscountPurchase;bread;1.55;1;0.02;1.53,
                 Purchase;milk;1.31;2;2.62,
                 Purchase;bread;1.54;3;4.62,
                 Purchase;bread;1.45;5;7.25,
                 PriceDiscountPurchase;potato;1.80;2;0.10;3.40,
                 Purchase;butter;3.70;1;3.70,
                 PriceDiscountPurchase;butter;3.41;1;0.01;3.40,
                 PriceDiscountPurchase;meat;11.00;2;0.80;20.40""";
        Assert.assertEquals(RESULT_STRING, purchases.toString());
    }

//    @Test
//    public void testSearchElement() {
//        final String FILENAME = "src/in.csv";
//        PurchaseList purchaseList = new PurchaseList(FILENAME);
//        List<Purchase> purchasesTest = new ArrayList<>();
//        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
//        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
//        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
//        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
//        Purchase purchase = purchaseList.searchElement(purchasesTest, new Purchase("milk", new Byn(131), 2));
//    }



}