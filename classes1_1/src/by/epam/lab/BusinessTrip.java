package by.epam.lab;

public class BusinessTrip {
    private static final int RATE = 900;
    private String account;
    private int transport;
    private int days;

    public BusinessTrip() {

    }

    public BusinessTrip(String account, int transport, int days) {
        this.account = account;
        this.transport = transport;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal() {
        return transport + RATE * days;
    }

    public String fromPennyToByn(int value) {
        int rub = value / 100;
        int kop = value % 100;
        if (kop == 0)
            return rub + "." + kop + "0";
        else {
            return rub + "." + kop;
        }
    }

    public void show() {
        System.out.println("rate = " + fromPennyToByn(RATE) + "\n" +
                "account = " + account + "\n" +
                "transport = " + fromPennyToByn(transport) + "\n" +
                "days = " + days + "\n" +
                "total = " + fromPennyToByn(getTotal()));
    }

    public String toString() {
        return account + ";" + fromPennyToByn(transport) + ";" + days + ";" + fromPennyToByn(getTotal());
    }
}
