import by.epam.lab.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {

    @Test
    public void testCreatingPurchasesEntities() {
        Scanner sc1 = new Scanner("GENERAL_PURCHASE Milk 140 3");
        Purchase purchase1 = PurchasesFactory.getPurchaseFromFactory(sc1);
        Scanner sc2 = new Scanner("FIRST_PURCHASE Sausage 490 4 10");
        Purchase purchase2 = PurchasesFactory.getPurchaseFromFactory(sc2);
        Scanner sc3 = new Scanner("SECOND_PURCHASE Bread 110 11 15");
        Purchase purchase3 = PurchasesFactory.getPurchaseFromFactory(sc3);
        Assert.assertEquals(new Purchase("Milk", new Byn(140), 3), purchase1);
        Assert.assertEquals(new FirstPurchase("Sausage", new Byn(490), 4, new Byn(10)), purchase2);
        Assert.assertEquals(new SecondPurchase("Bread", new Byn(110), 11, 15), purchase3);
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Assert.assertEquals(new Byn(420), p1.getCost());
        Purchase p2 = new FirstPurchase("Bread", new Byn(300), 2, new Byn(50));
        Assert.assertEquals(new Byn(500), p2.getCost());
        Purchase p3 = new SecondPurchase("Sausage", new Byn(500), 20, 5.825);
        Assert.assertEquals(new Byn(9418), p3.getCost());
        Purchase p4 = new Purchase("Meat", new Byn(1200), 6);
        Assert.assertEquals(new Byn(7200), p4.getCost());
        Purchase p5 = new FirstPurchase("Pasta", new Byn(210), 10, new Byn(25));
        Assert.assertEquals(new Byn(1850), p5.getCost());
        Purchase p6 = new SecondPurchase("Garlic", new Byn(170), 6, 13.6);
        Assert.assertEquals(new Byn(1020), p6.getCost());
    }

    @Test
    public void testEquals() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Purchase p2 = new Purchase("Milk", new Byn(140), 3);
        Assert.assertEquals(p1, p2);
        Purchase p3 = new FirstPurchase("Bread", new Byn(300), 2, new Byn(50));
        Purchase p4 = new FirstPurchase("Bread", new Byn(300), 2, new Byn(50));
        Assert.assertEquals(p3, p4);
        Purchase p5 = new SecondPurchase("Sausage", new Byn(500), 20, 5.825);
        Purchase p6 = new SecondPurchase("Sausage", new Byn(500), 20, 5.825);
        Assert.assertEquals(p5, p6);
    }

    @Test
    public void testMultiplicationInt() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(1500), byn.multiplication(3));
    }

    @Test
    public void testMultiplicationDouble() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(2913), byn.multiplication(5.825));
    }

    @Test
    public void testDifference() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(399), byn.difference(new Byn(101)));
    }

    @Test
    public void testSum() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(600), byn.sum(new Byn(100)));
    }
}