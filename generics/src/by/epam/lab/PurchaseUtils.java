package by.epam.lab;

public class PurchaseUtils {
    private final static String POSITIVE = "positive ";
    private final static String NEGATIVE = "negative ";
    private final static String DIFFERENCE = "diff = ";
    private final static String BYN = "BYN";
    private Purchase purchase;

    public PurchaseUtils() {
    }

    public PurchaseUtils(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println("cost = " + purchase.getPurchaseCost() + " BYN");
    }

    public void printCostDiff(Purchase purchase) {
        Byn difference;
        if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) == 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(DIFFERENCE + difference);
        } else if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) > 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(POSITIVE + DIFFERENCE + difference);
        } else if (this.purchase.getPurchaseCost().compareTo(purchase.getPurchaseCost()) < 0) {
            difference = this.purchase.getPurchaseCost().sub(purchase.getPurchaseCost());
            System.out.println(NEGATIVE + DIFFERENCE + difference);
        }
    }

    public void printlsSameCost(Purchase... purchases) {
        for (Purchase purchase1 : purchases) {
            if (purchase1.getPurchaseCost().compareTo(this.purchase.getPurchaseCost()) == 0) {
                System.out.println("True");
                System.out.println(purchase1);
            }
        }
    }
}
