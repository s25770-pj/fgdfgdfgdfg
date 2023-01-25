package pjwstk.Bank;

public class Transfer {
    private double value;
    private String status;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transfer(double value, String status) {
        this.value = value;
        this.status = status;
    }
}
