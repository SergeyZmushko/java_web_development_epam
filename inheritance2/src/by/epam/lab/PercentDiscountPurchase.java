package by.epam.lab;

public class PercentDiscountPurchase extends AbstractPurchase {
    private static final int COUNT = 10;
    private double percent;

    public PercentDiscountPurchase() {
        super();
    }

    public PercentDiscountPurchase(Product product, int number, double percent) {
        super(product, number);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    protected Byn getFinalCost(Byn baseCost) {
        Byn byn = baseCost;
        if (getUnitsNumber() > COUNT) {
            byn = baseCost.mul(1 - percent / 100);
        }
        return byn;
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + percent;
    }
}
