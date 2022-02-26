package by.epam.lab;

public class PriceDiscountPurchase extends Purchase {
    private final Byn discount;

    public PriceDiscountPurchase(String[] elements) {
        this(elements[0], elements[1], elements[2], elements[3]);
    }

    public PriceDiscountPurchase(String name, String price, String number, String discount) {
        super(name, price, number);
        if (discount != null && Integer.parseInt(discount) > 0) {
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
        return super.fieldToString() + getSemicolon() + discount;
    }
}
