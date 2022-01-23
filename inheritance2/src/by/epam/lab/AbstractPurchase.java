package by.epam.lab;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase>{
    private Product product;
    private int number;

    public AbstractPurchase(){

    }

    public AbstractPurchase(Product product, int number){
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

    public Byn getCost(){
        return floorRound(new Byn(product.getPrice().getValue() * number));
    }

    public static Byn floorRound(Byn byn){
        return new Byn((int) Math.floor(byn.getValue() / 100.0) * 100);
    }

    public String fieldsToString(){
        return getClass().getSimpleName() + ";" + product + ";" + number;
    }

    @Override
    public String toString(){
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase abstractPurchase) {
        return -getCost().getValue() + (abstractPurchase.getCost().getValue());
    }
}
