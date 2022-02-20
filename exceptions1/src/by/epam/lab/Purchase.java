package by.epam.lab;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {

    }

    public Purchase(String[] elements){
        if (elements[0] != null) {
            name = elements[0];
        }
        if (elements[1] != null && elements[2] != null && Integer.parseInt(elements[1]) > 0 && Integer.parseInt(elements[2]) > 0) {
            price = new Byn(Integer.parseInt(elements[1]));
            number = Integer.parseInt(elements[2]);
        }
    }

    public Purchase(String name, Byn price, int number) {
            this.name = name;
            this.price = price;
            this.number = number;
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

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldToString() {
        return getClass().getSimpleName() + ";" + name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return name.equals(purchase.name) && price.equals(purchase.price);
    }
}

