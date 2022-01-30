package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private int unitsNumber;

    public AbstractPurchase() {
        this.product = null;
    }

    public AbstractPurchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = unitsNumber;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public void setUnitsNumber(int unitsNumber) {
        this.unitsNumber = unitsNumber;
    }

    public Byn getCost() {
        Byn baseCost = product.getPrice().mul(unitsNumber);
        Byn finalCost = getFinalCost(baseCost);
        return finalCost.round(RoundMethod.FLOOR, 2);
    }

    protected abstract Byn getFinalCost(Byn baseCost);

    public String fieldsToString() {
        return getClass().getSimpleName() + ";" + product + ";" + unitsNumber;
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
