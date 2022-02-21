package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    //final делать??????
    private String name;
    private Byn price;
    private int number;
    private Byn totalCost;


    public Purchase(String[] elements) throws IllegalArgumentException {
        if (!isValid(elements)) {
            throw new IllegalArgumentException();
        }
        name = elements[0];
        price = new Byn(Integer.parseInt(elements[1]));
        number = Integer.parseInt(elements[2]);
        setTotalCost(calculateCost());
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    private boolean isValid(String[] elements) {
        if (elements[0] != null && !elements[0].isEmpty() && elements[1] != null && elements[2] != null &&
                Integer.parseInt(elements[1]) > 0 && Integer.parseInt(elements[2]) > 0) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return new Byn(price);
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

    public Byn calculateCost() throws IllegalArgumentException {
        return new Byn(price).mul(number);
    }

    protected String fieldToString() {
        return getClass().getSimpleName() + ";" + name + ";" + price + ";" + number;
    }

    public Byn getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return fieldToString() + ";" + totalCost;
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

