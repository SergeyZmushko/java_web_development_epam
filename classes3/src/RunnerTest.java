import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import by.epam.lab.WeekDay;
import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {
    @Test
    public void testPurchaseInit() {
        Purchase p1 = new Purchase(1, 10, WeekDay.FRIDAY);
        Purchase p2 = new Purchase(1, 10, 5);
        Assert.assertEquals(p1.getDay(), p2.getDay());
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(3, 5, WeekDay.FRIDAY);
        Assert.assertEquals(4300, p1.getCost());
        Purchase p2 = new Purchase(3, 6, WeekDay.FRIDAY);
        Assert.assertEquals(4200, p2.getCost());
        Purchase p3 = new Purchase(1, 6.7, WeekDay.FRIDAY);
        Assert.assertEquals(1400, p3.getCost());
        Purchase p4 = new Purchase(1, 4.1, WeekDay.FRIDAY);
        Assert.assertEquals(1400, p4.getCost());
    }

    @Test
    public void testToByn() {
        Assert.assertEquals("3.50", Utils.fromPennyToByn(350));
        Assert.assertEquals("3.05", Utils.fromPennyToByn(305));
        Assert.assertEquals("0.05", Utils.fromPennyToByn(5));
        Assert.assertEquals("0.00", Utils.fromPennyToByn(0));
        Assert.assertEquals("1005.00", Utils.fromPennyToByn(100500));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testThrowingException() {
        Purchase p1 = new Purchase(4, 20.3, 8);
        p1 = new Purchase(4, 20.3, -2);
    }
}

