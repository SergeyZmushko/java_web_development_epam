import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {
    @Test
    public void testPurchaseInit() {
        Purchase p1 = new Purchase(1, 10, 0);
        Purchase p2 = new Purchase(3, 22, 3);
        Assert.assertTrue(p1.getNumber() == 1 && p1.getPercent() == 10 && p1.getDay() == 0);
        Assert.assertTrue(p2.getNumber() == 3 && p2.getPercent() == 22 && p2.getDay() == 3);
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(3, 5, 6);
        Assert.assertEquals(4300, p1.getCost());
        Purchase p2 = new Purchase(1, 40, 4);
        Assert.assertEquals(900, p2.getCost());
    }

    @Test
    public void testToByn() {
        Assert.assertEquals("0.40", Utils.fromPennyToByn(40));
        Assert.assertEquals("123.00", Utils.fromPennyToByn(12300));
    }
}
