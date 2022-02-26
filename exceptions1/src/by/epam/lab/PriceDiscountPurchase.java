package by.epam.lab;

public class PriceDiscountPurchase extends Purchase {
    private final Byn discount;

    public PriceDiscountPurchase(String[] elements) {
        this(elements[INDEX_NAME], elements[INDEX_PRICE], elements[INDEX_NUMBER], elements[INDEX_DISCOUNT]);
    }

    public PriceDiscountPurchase(String name, String price, String number, String discount) {
        super(name, price, number);
        if (discount != null && Integer.parseInt(discount) > 0 && !discount.trim().isEmpty()) {
            this.discount = new Byn(Integer.parseInt(discount));
            setTotalCost(calculatePriceDiscountCost());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Byn getDiscount() {
        return discount;
    }

    public Byn calculatePriceDiscountCost() {
        return getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + semicolon + discount;
    }
}
