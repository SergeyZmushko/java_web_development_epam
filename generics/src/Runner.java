import by.epam.lab.beans.*;
import by.epam.lab.implement.Priceable;
import by.epam.lab.utils.PurchaseUtils;

public class Runner {
    public static void main(String[] args) {
        //1
        Purchase<Product, Integer> p1 = new Purchase<>(new Product("Milk", new Byn(170)), 20);
        //2
        PurchaseUtils<Product, Integer> pu1 = new PurchaseUtils<>(p1);
        pu1.printPurchase();
        pu1.printCost();
        //3
        Purchase<Product, Double> p2 = new Purchase<>(new Product("Sugar", new Byn(300)), 12.5);
        //4
        PurchaseUtils<Product, Double> pu2 = new PurchaseUtils<>(p2);
        pu2.printCost();
        pu2.printCostDiff(p1);
        //5
        Purchase<DiscountProduct, Integer> p3 = new Purchase<>(new DiscountProduct("Sugar", new Byn(280),
                new Byn(10)), 60);
        //6
        PurchaseUtils<Service, Double> pu4 = new PurchaseUtils<>(new Purchase<>(
                new Service("Gym workout", new Byn(7560), 5), 2.25));
        //7
        Service s4 = pu4.getPurchase().getItem();
        System.out.println(s4);
        //8
        pu4.printCost();
        //9
        pu2.<Purchase<? extends Priceable, ? extends Number>>printSameCost(p1, p3, pu4.getPurchase());
    }
}
