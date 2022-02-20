package by.epam.lab;


public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(String[] elements) {
        super(elements[0], new Byn(Integer.parseInt(elements[1])), Integer.parseInt(elements[2]));
        if (elements[3] != null && Integer.parseInt(elements[3]) > 0) {
            discount = new Byn(Integer.parseInt(elements[3]));
        }
    }

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + discount;
    }
}
