package by.epam.lab.beans;

import by.epam.lab.exceptions.NonPositiveArgumentException;

import java.util.Objects;

public class PriceDiscountPurchase extends Purchase {
    protected final static int PURCHASE_DISCOUNT_FIELD_NUMBER = 4;
    private final Byn discount;

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        if (discount.compareTo(new Byn()) < 1 || price.compareTo(discount) <= 0) {
            throw new NonPositiveArgumentException("wrong field discount: " + discount);
        }
        this.discount = discount;
    }

    public PriceDiscountPurchase(String[] fields) {
        this(getValidPurchaseDiscount(fields));
    }

    public PriceDiscountPurchase(PriceDiscountPurchase purchase) {
        this(purchase.getName(), purchase.getPrice(), purchase.getNumber(), purchase.discount);
    }

    private static PriceDiscountPurchase getValidPurchaseDiscount(String[] fields) {
        if (fields.length != PURCHASE_DISCOUNT_FIELD_NUMBER) {
            throw new ArrayIndexOutOfBoundsException(WRONG_ARGS_NUMBER);
        }
        return new PriceDiscountPurchase(fields[INDEX_NAME], new Byn(fields[INDEX_PRICE]),
                Integer.parseInt(fields[INDEX_NUMBER]), new Byn(fields[INDEX_DISCOUNT]));
    }

    public Byn getDiscount() {
        return discount;
    }

    public Byn getCost() {
        return getPrice().sub(discount).mul(getNumber());
    }

    @Override
    protected String fieldToString() {
        return super.fieldToString() + semicolon + discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PriceDiscountPurchase that = (PriceDiscountPurchase) o;
        return Objects.equals(discount, that.discount);
    }

}
