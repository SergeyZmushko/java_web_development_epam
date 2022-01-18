import by.epam.lab.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestRunner {

    @Test
    public void testClassByn() {
        Byn byn1 = new Byn(200);
        Byn byn2 = new Byn(100);
        byn1.add(byn2);
        Assert.assertEquals(new Byn(300), byn1);
        Assert.assertEquals("3.00", byn1.toString());
        byn1.mul(2);
        Assert.assertEquals(new Byn(600), byn1);
        byn1.sub(new Byn(300));
        Assert.assertEquals(new Byn(300), byn1);
    }

    @Test
    public void testFabricMethod() {
        Scanner sc1 = new Scanner("GENERAL_PURCHASE Milk 140 3");
        Purchase purchase1 = PurchasesFactory.getPurchaseFromFactory(sc1);
        Scanner sc2 = new Scanner("PRICE_DISCOUNT_PURCHASE Sausage 490 4 10");
        Purchase purchase2 = PurchasesFactory.getPurchaseFromFactory(sc2);
        Scanner sc3 = new Scanner("PERCENT_DISCOUNT_PURCHASE Bread 110 11 15");
        Purchase purchase3 = PurchasesFactory.getPurchaseFromFactory(sc3);
        Assert.assertEquals(new Purchase("Milk", new Byn(140), 3), purchase1);
        Assert.assertEquals(new PriceDiscountPurchase("Sausage", new Byn(490), 4, new Byn(10)), purchase2);
        Assert.assertEquals(new PercentDiscountPurchase("Bread", new Byn(110), 11, 15), purchase3);
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Assert.assertEquals(new Byn(420), p1.getCost());
        Assert.assertEquals(new Byn(140), p1.getPrice());
        PriceDiscountPurchase p2 = new PriceDiscountPurchase("Bread", new Byn(300), 2, new Byn(50));
        Assert.assertEquals(new Byn(500), p2.getCost());
        Assert.assertEquals(new Byn(300), p2.getPrice());
        Assert.assertEquals(new Byn(50), p2.getDiscount());
        PercentDiscountPurchase p3 = new PercentDiscountPurchase("Sausage", new Byn(500), 20, 5.825);
        Assert.assertEquals(new Byn(9418), p3.getCost());
        Assert.assertEquals(new Byn(500), p3.getPrice());
        Purchase p4 = new Purchase("Meat", new Byn(1200), 6);
        Assert.assertEquals(new Byn(7200), p4.getCost());
        Assert.assertEquals(new Byn(1200), p4.getPrice());
        PriceDiscountPurchase p5 = new PriceDiscountPurchase("Pasta", new Byn(210), 10, new Byn(25));
        Assert.assertEquals(new Byn(1850), p5.getCost());
        Assert.assertEquals(new Byn(210), p5.getPrice());
        Assert.assertEquals(new Byn(25), p5.getDiscount());
        PercentDiscountPurchase p6 = new PercentDiscountPurchase("Garlic", new Byn(170), 6, 13.6);
        Assert.assertEquals(new Byn(1020), p6.getCost());
        Assert.assertEquals(new Byn(170), p6.getPrice());
    }

    @Test
    public void testEquals() {
        Purchase p1 = new Purchase("Milk", new Byn(140), 3);
        Purchase p2 = new PriceDiscountPurchase("Milk", new Byn(140), 3, new Byn(50));
        Purchase p3 = new PercentDiscountPurchase("Milk", new Byn(140), 3, 5.825);
        Assert.assertEquals(p1, p2);
        Assert.assertEquals(p2, p3);
        Assert.assertEquals(p1, p3);
    }

    @Test
    public void testMul() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(1500), byn.mul(3));
    }

    @Test
    public void testMulWithDoubleAndRound() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(2913), byn.mul(5.825, RoundMethod.ROUND, 1));
    }

    @Test
    public void testSub() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(399), byn.sub(new Byn(101)));
    }

    @Test
    public void testSum() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(600), byn.add(new Byn(100)));
    }

    @Test
    public void testRound() {
        Byn byn = new Byn(28496);
        Assert.assertEquals(new Byn(28500), byn.round(RoundMethod.ROUND, 2));
    }

}