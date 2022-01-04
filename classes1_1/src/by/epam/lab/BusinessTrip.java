package by.epam.lab;

public class BusinessTrip {
    private static final int DAILY_RATE = 950;
    private String account;
    private int expenses;
    private int daysNumber;

    public BusinessTrip() {

    }

    public BusinessTrip(String account, int expenses, int daysNumber) {
        this.account = account;
        this.expenses = expenses;
        this.daysNumber = daysNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        this.daysNumber = daysNumber;
    }

    public int getTotal() {
        return expenses + DAILY_RATE * daysNumber;
    }

    private static String fromPennyToByn(int penny) {
        return String.format("%d.%02d", penny / 100, penny % 100);
    }

    public void show() {
        System.out.println("rate = " + fromPennyToByn(DAILY_RATE) + "\n" +
                "account = " + account + "\n" +
                "expenses = " + fromPennyToByn(expenses) + "\n" +
                "daysNumber = " + daysNumber + "\n" +
                "total = " + fromPennyToByn(getTotal()));
    }

    public String toString() {
        return account + ";" + fromPennyToByn(expenses) + ";" +
                daysNumber + ";" + fromPennyToByn(getTotal());
    }
}
