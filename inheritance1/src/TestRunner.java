import by.epam.lab.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestRunner {

    @Test
    public void testCreatingPurchasesEntities() {
        Purchase[] purchases = new Purchase[6];
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(purchases[0], new Purchase("Milk", new Byn(140), 3));
        Assert.assertEquals(purchases[1], new SecondPurchase("Bread", new Byn(110), 11, 15));
        Assert.assertEquals(purchases[2], new FirstPurchase("Sausage", new Byn(490), 4, 10));
        Assert.assertEquals(purchases[3], new Purchase("Meat", new Byn(1200), 6));
        Assert.assertEquals(purchases[4], new FirstPurchase("Pasta", new Byn(210), 10, 25));
        Assert.assertEquals(purchases[5], new SecondPurchase("Garlic", new Byn(170), 6, 13));
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Assert.assertEquals(new Byn(420), p1.getCost());
        Purchase p2 = new FirstPurchase("Bread", new Byn(300), 2, 50);
        Assert.assertEquals(new Byn(500), p2.getCost());
        Purchase p3 = new SecondPurchase("Sausage", new Byn(500), 20, 5.825);
        Assert.assertEquals(new Byn(9418), p3.getCost());
        Purchase p4 = new Purchase("Meat", new Byn(1200), 6);
        Assert.assertEquals(new Byn(7200), p4.getCost());
        Purchase p5 = new FirstPurchase("Pasta", new Byn(210), 10, 25);
        Assert.assertEquals(new Byn(1850), p5.getCost());
        Purchase p6 = new SecondPurchase("Garlic", new Byn(170), 6, 13.6);
        Assert.assertEquals(new Byn(1020), p6.getCost());
    }

    @Test
    public void testEquals() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Purchase p2 = new Purchase("Milk", new Byn(140), 3);
        Assert.assertEquals(p1, p2);
        Purchase p3 = new FirstPurchase("Bread", new Byn(300), 2, 50);
        Purchase p4 = new FirstPurchase("Bread", new Byn(300), 2, 50);
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
        Assert.assertEquals(new Byn(399), byn.difference(100.56));
    }

    @Test
    public void testSum() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(600), byn.sum(new Byn(100)));
    }
}