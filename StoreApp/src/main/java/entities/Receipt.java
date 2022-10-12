package entities;

import java.math.BigInteger;

public class Receipt {
    private String customerName;
    private BigInteger totalCost;
    private String message= "Thanks for patronising us";




    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigInteger getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigInteger totalCost) {
        this.totalCost = totalCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Receipt( String customerName, BigInteger totalCost) {
        this.customerName = customerName;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                " customerName='" + customerName + '\'' +
                ", totalCost=" + totalCost +
                ", message='" + message + '\'' +
                '}';
    }
}
