import by.epam.lab.*;

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
        Purchase p3 = new Purchase(new DiscountProduct("Sugar", new Byn(280), new Byn(1)), 60);
        //6
        PurchaseUtils pu4 = new PurchaseUtils(new Purchase(new Service("Gym workout", new Byn(7560), 5), 2.25));
        //7
        Service s1 = new Service(pu4.getPurchase().getItem().getName(), pu4.getPurchase().getPurchaseCost(), pu4.getPurchase().getCount());
        System.out.println(s1);
        //8
        pu4.printCost();
    }
}
