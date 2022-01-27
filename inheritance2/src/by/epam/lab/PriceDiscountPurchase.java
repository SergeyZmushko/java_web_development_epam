package by.epam.lab;

public class PriceDiscountPurchase extends AbstractPurchase {
    private Byn discount;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(Product product, int number, Byn discount) {
        super(product, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public void setDiscount(Byn discount) {
        this.discount = discount;
    }

    @Override
    protected Byn getCostCalculate() {
        return new Byn((getProduct().getPrice()).sub(discount).mul(getNumber()));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
