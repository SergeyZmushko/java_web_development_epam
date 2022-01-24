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
    public Byn getCost() {
        return new Byn((getProduct().getPrice()).sub(discount).mul(getNumber())).round(RoundMethod.FLOOR, 2);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}
