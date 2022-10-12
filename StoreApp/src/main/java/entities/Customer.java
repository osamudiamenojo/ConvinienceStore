package entities;

import enums.Gender;

import java.math.BigInteger;
import java.util.ArrayList;

public class Customer extends Person{
    private BigInteger cashAtHand;

    private Product productToBuy;


    public Customer() {
    }

    public Customer(String name, Gender gender, BigInteger cashAtHand) {
        super(name, gender);
        this.cashAtHand = cashAtHand;
    }

    public BigInteger getCashAtHand() {
        return cashAtHand;
    }

    public void setCashAtHand(BigInteger cashAtHand) {
        this.cashAtHand = cashAtHand;
    }
    public Product getProductToBuy() {
        return productToBuy;
    }

    public void setProductToBuy(Product productToBuy) {
        this.productToBuy = productToBuy;
    }



}
