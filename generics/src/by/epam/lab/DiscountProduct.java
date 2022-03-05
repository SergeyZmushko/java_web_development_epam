package by.epam.lab;

public class DiscountProduct extends Product {
    private final Byn discount;

    public DiscountProduct(String name, Byn price, Byn discount) {
        super(name, price);
        this.discount = discount;
    }

    @Override
    protected Byn getCost() {
        return getPrice().sub(discount);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + Constant.SEPARATOR + discount;
    }
}
