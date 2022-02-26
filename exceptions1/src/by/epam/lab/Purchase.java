package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    private final String name;
    private final Byn price;
    private final int number;
    private Byn totalCost;
    private final String semicolon = ";";

    public Purchase(String[] elements) {
        this(elements[0], elements[1], elements[2]);
    }

    public Purchase(String name, String price, String number) {
        String[] elements = {name, price, number};
        if (!isValid(elements)) {
            throw new IllegalArgumentException();
        }
        this.name = elements[0];
        this.price = new Byn(Integer.parseInt(elements[1]));
        this.number = Integer.parseInt(elements[2]);
        setTotalCost(calculateCost());
    }

    private boolean isValid(String[] elements) {
        String element_0 = elements[0];
        String element_1 = elements[1];
        String element_2 = elements[2];
        return element_0 != null && !element_0.isEmpty() && element_1 != null && element_2 != null &&
                Integer.parseInt(element_1) > 0 && Integer.parseInt(element_2) > 0;
    }

    public Byn getPrice() {
        return price;
    }

    public String getSemicolon() {
        return semicolon;
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

