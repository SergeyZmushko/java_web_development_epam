import by.epam.lab.Purchase;
import by.epam.lab.Utils;
import by.epam.lab.WeekDay;
import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {
    @Test
    public void testPurchaseInit() {
        Purchase p1 = new Purchase(1, 10, WeekDay.FRIDAY);
        Purchase p2 = new Purchase(3, 22, WeekDay.SATURDAY);
        Assert.assertTrue(p1.getNumber() == 1 && p1.getPercent() == 10 && p1.getDay() == WeekDay.FRIDAY);
        Assert.assertTrue(p2.getNumber() == 3 && p2.getPercent() == 22 && p2.getDay() == WeekDay.SATURDAY);
    }

    @Test
    public void testGetCost() {
        Purchase p1 = new Purchase(3, 5, WeekDay.FRIDAY);
        Assert.assertEquals(4300, p1.getCost());
        Purchase p2 = new Purchase(1, 40, WeekDay.MONDAY);
        Assert.assertEquals(900, p2.getCost());
    }

    @Test
    public void testToByn() {
        Assert.assertEquals("0.40", Utils.fromPennyToByn(40));
        Assert.assertEquals("123.00", Utils.fromPennyToByn(12300));
    }
}
