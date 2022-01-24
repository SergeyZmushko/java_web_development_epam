package by.epam.lab;

public class TransportExpensesPurchase extends AbstractPurchase {
    private Byn transportExpenses;

    public TransportExpensesPurchase() {
        super();
    }

    public TransportExpensesPurchase(Product product, int number, Byn transportExpenses) {
        super(product, number);
        this.transportExpenses = transportExpenses;
    }

    public Byn getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Byn transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    @Override
    public Byn getCost() {
        return new Byn(super.getCost().add(transportExpenses)).round(RoundMethod.FLOOR, 2);
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
}
