import by.epam.lab.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RunnerTest {

    @Test
    public void testGetCost() {
        Product product = new Product("Milk", new Byn(150));
        PriceDiscountPurchase p1 = new PriceDiscountPurchase(product, 4, new Byn(50));
        Assert.assertEquals(new Byn(400), p1.getCost());
        PercentDiscountPurchase p2 = new PercentDiscountPurchase(product, 4, 20);
        Assert.assertEquals(new Byn(600), p2.getCost());
        PercentDiscountPurchase p3 = new PercentDiscountPurchase(product, 11, 22.3);
        Assert.assertEquals(new Byn(1200), p3.getCost());
        TransportExpensesPurchase p4 = new TransportExpensesPurchase(product, 5, new Byn(20));
        Assert.assertEquals(new Byn(700), p4.getCost());
    }

    @Test
    public void testSearchWhereDesiredObjectLast() {
        Product product = new Product("Bread", new Byn(50));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 20, new Byn(2)),
                new TransportExpensesPurchase(product, 9, new Byn(100)),
                new PercentDiscountPurchase(product, 15, 20),
                new PriceDiscountPurchase(product, 30, new Byn(0))
        };
        Arrays.sort(purchases);
        int lastInArray = Runner.search(purchases);
        Assert.assertEquals(purchases[purchases.length - 1], purchases[lastInArray]);
    }

    @Test
    public void testSearchWhereDesiredObjectFirst() {
        Product product = new Product("Bread", new Byn(50));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 1, new Byn(2)),
                new TransportExpensesPurchase(product, 9, new Byn(100)),
                new PercentDiscountPurchase(product, 2, 20),
                new PriceDiscountPurchase(product, 3, new Byn(0))
        };
        Arrays.sort(purchases);
        int firstInArray = Runner.search(purchases);
        Assert.assertEquals(purchases[0], purchases[firstInArray]);
    }

    @Test
    public void testSearchWhereDesiredObjectLessThanMin() {
        Product product = new Product("Bread", new Byn(50));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 20, new Byn(2)),
                new TransportExpensesPurchase(product, 11, new Byn(100)),
                new PercentDiscountPurchase(product, 15, 20),
                new PriceDiscountPurchase(product, 30, new Byn(0))
        };
        Arrays.sort(purchases);
        int lessThanMin = Runner.search(purchases);
        Assert.assertEquals(-5, lessThanMin);
    }

    @Test
    public void testSearchWhereDesiredObjectMoreThanMax() {
        Product product = new Product("Bread", new Byn(50));
        AbstractPurchase[] purchases = {
                new PriceDiscountPurchase(product, 1, new Byn(2)),
                new TransportExpensesPurchase(product, 6, new Byn(100)),
                new PercentDiscountPurchase(product, 2, 20),
                new PriceDiscountPurchase(product, 3, new Byn(0))
        };
        Arrays.sort(purchases);
        int moreThanMax = Runner.search(purchases);
        Assert.assertEquals(-1, moreThanMax);
    }

    @Test
    public void testMul() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(1500), byn.mul(3));
    }

    @Test
    public void testMulWithDoubleAndRound() {
        Byn byn = new Byn(500);
        Assert.assertEquals(new Byn(2900), byn.mul(5.825, RoundMethod.FLOOR, 2));
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
        Assert.assertEquals(new Byn(28400), byn.round(RoundMethod.FLOOR, 2));
    }
}
