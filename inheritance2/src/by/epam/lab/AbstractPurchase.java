package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Product product;
    private int number;

    public AbstractPurchase() {

    }

    public AbstractPurchase(Product product, int number) {
        this.product = product;
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(getProduct().getPrice()).mul(number).round(RoundMethod.FLOOR, 2);
    }

    public String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return purchase.getCost().compareTo(getCost());
    }
}
