package by.epam.lab;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String[] elements) throws IllegalArgumentException{
        super(elements);
        String stringDiscount = elements[3];
        if (stringDiscount != null && Integer.parseInt(stringDiscount) > 0) {
            discount = new Byn(Integer.parseInt(stringDiscount));
            setTotalCost(calculatePriceDiscountCost());
        }else{
            throw new IllegalArgumentException();
        }
    }

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public Byn getDiscount() {
        return discount;
    }

    public Byn calculatePriceDiscountCost(){
        return getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + discount;
    }
}
