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
    public Byn getCostCalculate() {
        Byn byn = new Byn(getProduct().getPrice()).mul(getNumber());
        if (getNumber() > COUNT) {
            byn.mul(1 - percent / 100).round(RoundMethod.FLOOR, 2);
        }
        return byn;
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + percent;
    }
}
