package pjwstk.Bank;

public class Client {
    private String id;
    private double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }
}
