package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    protected final static int INDEX_NAME = 0;
    protected final static int INDEX_PRICE = 1;
    protected final static int INDEX_NUMBER = 2;
    protected final static int INDEX_DISCOUNT = 3;
    protected final String semicolon = ";";
    private final String name;
    private final Byn price;
    private final int number;
    private Byn totalCost;

    public Purchase(String[] elements) {
        this(elements[INDEX_NAME], elements[INDEX_PRICE], elements[INDEX_NUMBER]);
    }

    public Purchase(String name, String price, String number) {
        String[] elements = {name, price, number};
        if (!isValid(elements)) {
            throw new IllegalArgumentException();
        }
        this.name = elements[INDEX_NAME];
        this.price = new Byn(Integer.parseInt(elements[INDEX_PRICE]));
        this.number = Integer.parseInt(elements[INDEX_NUMBER]);
        setTotalCost(calculateCost());
    }

    private boolean isValid(String[] elements) {
        String element_0 = elements[INDEX_NAME];
        String element_1 = elements[INDEX_PRICE];
        String element_2 = elements[INDEX_NUMBER];
        return element_0 != null && !element_0.trim().isEmpty() && !element_0.isEmpty() && element_1 != null &&
                !element_1.trim().isEmpty() && element_2 != null && !element_2.trim().isEmpty() &&
                Integer.parseInt(element_1) > 0 && Integer.parseInt(element_2) > 0;
    }

    public Byn getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    protected void setTotalCost(Byn totalCost) {
        if (!totalCost.isPositive()) {
            throw new IllegalArgumentException();
        }
        this.totalCost = totalCost;
    }

    private Byn calculateCost() {
        return price.mul(number);
    }

    protected String fieldToString() {
        return getClass().getSimpleName() + semicolon + name + semicolon + price + semicolon + number;
    }

    public Byn getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return fieldToString() + semicolon + totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return name.equals(purchase.name) && price.equals(purchase.price);
    }

    @Override
    public int compareTo(Purchase o) {
        return totalCost.compareTo(o.getTotalCost());
    }
}

