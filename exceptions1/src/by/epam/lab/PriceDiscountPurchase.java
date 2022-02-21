package by.epam.lab;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String[] elements) throws IllegalArgumentException{
        super(elements);
        if (elements[3] != null && Integer.parseInt(elements[3]) > 0) {
            discount = new Byn(Integer.parseInt(elements[3]));
            setTotalCost(calculate());
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


    public Byn calculate(){
        return getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + discount;
    }
}
