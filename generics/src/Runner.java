import by.epam.lab.beans.*;
import by.epam.lab.utills.PurchaseUtils;

public class Runner {
    public static void main(String[] args) {
        //1
        Purchase p1 = new Purchase(new Product("Milk", new Byn(170)), 20);
        //2
        PurchaseUtils pu1 = new PurchaseUtils(p1);
        pu1.printPurchase();
        pu1.printCost();
        //3
        Purchase p2 = new Purchase(new Product("Sugar", new Byn(300)), 12.5);
        //4
        PurchaseUtils pu2 = new PurchaseUtils(p2);
        pu2.printCost();
        pu2.printCostDiff(p1);
        //5
        Purchase p3 = new Purchase(new DiscountProduct("Sugar", new Byn(280), new Byn(10)), 60);
        //6
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(new Service("Gym workout", new Byn(7560),
                5), 2.25));
        //7
        Service s4 = (Service) pu4.getPurchase().getItem();
        System.out.println(s4);
        //8
        pu4.printCost();
        //9
        Purchase p4 = new Purchase(s4, pu4.getPurchase().getCount());
        pu2.printlsSameCost(p1, p3, p4);
    }
}
