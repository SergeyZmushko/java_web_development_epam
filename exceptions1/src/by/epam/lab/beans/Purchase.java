package by.epam.lab.beans;

import by.epam.lab.exceptions.NonPositiveArgumentException;

public class Purchase {
    protected final static int INDEX_NAME = 0;
    protected final static int INDEX_PRICE = 1;
    protected final static int INDEX_NUMBER = 2;
    protected final static int INDEX_DISCOUNT = 3;
    protected final static int PURCHASE_FIELD_NUMBER = 3;
    protected final static String WRONG_ARGS_NUMBER = "wrong args number: ";
    protected final static String WRONG_FIELD_NAME = "wrong field name: ";
    protected final static String WRONG_FIELD_PRICE = "wrong field price: ";
    protected final static String WRONG_FIELD_NUMBER = "wrong field number:";
    protected final String semicolon = ";";
    private final String name;
    private final Byn price;
    private final int number;

    public Purchase(String name, Byn price, int number) {
        if (name.trim().isEmpty()) {
            throw new NonPositiveArgumentException(WRONG_FIELD_NAME + name);
        }
        if (price.compareTo(new Byn()) < 1) {
            throw new NonPositiveArgumentException(WRONG_FIELD_PRICE + price);
        }
        if (number <= 0) {
            throw new NonPositiveArgumentException(WRONG_FIELD_NUMBER + number);
        }
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(String[] fields) {
        this(getValidPurchase(fields));
    }

    private static Purchase getValidPurchase(String[] fields) {
        if (fields.length != PURCHASE_FIELD_NUMBER) {
            throw new ArrayIndexOutOfBoundsException(WRONG_ARGS_NUMBER);
        }
        return new Purchase(fields[INDEX_NAME], new Byn(fields[INDEX_PRICE]), Integer.parseInt(fields[INDEX_NUMBER]));
    }

    public Purchase(Purchase purchase) {
        this(purchase.name, purchase.price, purchase.number);
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Byn getCost() {
        return price.mul(number);
    }

    protected String fieldToString() {
        return getClass().getSimpleName() + semicolon + name + semicolon + price + semicolon + number;
    }

    @Override
    public String toString() {
        return fieldToString() + semicolon + getCost();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return name.equals(purchase.name) && price.equals(purchase.price);
    }

}

