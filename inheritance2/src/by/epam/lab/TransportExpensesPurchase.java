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
    protected Byn getCostCalculate() {
        return new Byn(getProduct().getPrice().mul(getNumber()).add(transportExpenses));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + transportExpenses;
    }
}
