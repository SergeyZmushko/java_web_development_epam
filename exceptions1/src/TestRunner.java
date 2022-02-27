import by.epam.lab.*;
import by.epam.lab.beans.Byn;
import by.epam.lab.beans.PriceDiscountPurchase;
import by.epam.lab.beans.Purchase;
import by.epam.lab.exceptions.CsvLineException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class TestRunner {
    private final static String FILENAME = "src/in.csv";
    private final Comparator<Purchase> comparator = new Comparator<>() {
        @Override
        public int compare(Purchase o1, Purchase o2) {
            return o1.getCost().compareTo(o2.getCost());
        }
    };

    @Test
    public void testFabricMethod() throws CsvLineException {
        String purchaseString = "bread;155;1";
        String priceDiscountPurchaseString = "potato;180;2;10";
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchaseString);
        Purchase priceDiscountPurchaseObj = PurchaseFactory.getPurchaseFromFactory(priceDiscountPurchaseString);
        assertEquals(new Purchase("bread", new Byn(155), 1), purchaseObj);
        assertEquals(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)), priceDiscountPurchaseObj);
    }

    @Test(expected = CsvLineException.class)
    public void testFabricMethodExceptionWhenElementsLessRequired() throws CsvLineException {
        String purchase = "bread;155";
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
    }

    @Test(expected = CsvLineException.class)
    public void testFabricMethodExceptionWhenElementsMoreRequired() throws CsvLineException {
        String purchase = "bread;155;2;10;d";
        Purchase purchaseObj = PurchaseFactory.getPurchaseFromFactory(purchase);
    }

    @Test
    public void testPurchaseListConstructor() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testAddElementIntoRightPos() {
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
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        purchaseList.addElementIntoPos(2, new Purchase("butter", new Byn(370), 1));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testAddElementIntoPosLesZero() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        purchaseList.addElementIntoPos(-2, new Purchase("butter", new Byn(370), 1));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testAddElementIntoPosMoreMaxIndex() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        purchaseList.addElementIntoPos(60, new Purchase("butter", new Byn(370), 1));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testCalculateTotalCost() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        Byn totalCost = purchaseList.calculateTotalCost();
        assertEquals(new Byn(4692), totalCost);
    }

    @Test
    public void testDeleteSubsequenceWithCorrectIndexes() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        int deletedElements = purchaseList.deleteSubsequence(0, 2);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertEquals(2, deletedElements);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testDeleteSubsequenceWithIncorrectIndexes() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        int deletedElements = purchaseList.deleteSubsequence(-2, 22);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(0, deletedElements);
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testDeleteSubsequenceWithIncorrectIndexesFromMoreThanTo() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        int deletedElements = purchaseList.deleteSubsequence(5, 2);
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(0, deletedElements);
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertFalse(purchaseList.isSorted());
    }

    @Test
    public void testGetPurchases() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
    }

    @Test
    public void testListSort() {
        List<Purchase> purchasesTest = new ArrayList<>();
        purchasesTest.add(new PriceDiscountPurchase("bread", new Byn(155), 1, new Byn(2)));
        purchasesTest.add(new Purchase("milk", new Byn(131), 2));
        purchasesTest.add(new PriceDiscountPurchase("potato", new Byn(180), 2, new Byn(10)));
        purchasesTest.add(new PriceDiscountPurchase("butter", new Byn(341), 1, new Byn(1)));
        purchasesTest.add(new Purchase("butter", new Byn(370), 1));
        purchasesTest.add(new Purchase("bread", new Byn(154), 3));
        purchasesTest.add(new Purchase("bread", new Byn(145), 5));
        purchasesTest.add(new PriceDiscountPurchase("meat", new Byn(1100), 2, new Byn(80)));
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        purchaseList.listSort();
        String purchasesActual = purchaseList.stringRepresentationOfList();
        assertEquals(purchasesTest.toString(), purchasesActual);
        assertTrue(purchaseList.isSorted());
    }

    @Test
    public void testStringRepresentation() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        String listToString = purchaseList.stringRepresentationOfList();
        final String resultString =
                "[PriceDiscountPurchase;bread;1.55;1;0.02;1.53, " + "Purchase;milk;1.31;2;2.62, " +
                        "Purchase;bread;1.54;3;4.62, " + "Purchase;bread;1.45;5;7.25, " +
                        "PriceDiscountPurchase;potato;1.80;2;0.10;3.40, " + "Purchase;butter;3.70;1;3.70, " +
                        "PriceDiscountPurchase;butter;3.41;1;0.01;3.40, " + "PriceDiscountPurchase;meat;11.00;2;0.80;20.40]";
        assertEquals(resultString, listToString);
    }

    @Test
    public void testSearchElement() {
        PurchaseList purchaseList = new PurchaseList(FILENAME, comparator);
        int i = purchaseList.searchElement(new Purchase("milk", new Byn(131), 2));
        assertEquals(1, i);
    }

}