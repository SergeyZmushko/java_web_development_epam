package by.epam.lab;


public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(String[] elements) throws IllegalArgumentException{
        super(elements[0], new Byn(Integer.parseInt(elements[1])), Integer.parseInt(elements[2]));
        if (elements[3] != null && Integer.parseInt(elements[3]) > 0) {
            discount = new Byn(Integer.parseInt(elements[3]));
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

    @Override
    public Byn getCost() throws IllegalArgumentException {
        Byn getCost = new Byn(getPrice()).sub(discount).mul(getNumber());
        if (getCost.compareTo(new Byn(0)) > 0){
            return getCost;
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + ";" + discount;
    }
}
