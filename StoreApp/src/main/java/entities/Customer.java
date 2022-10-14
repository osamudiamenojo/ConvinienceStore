package entities;
import enums.Gender;
import lombok.*;

@Getter
@Setter

public class Customer extends Person {

    private double CashAtHand;
    private Product productToBuy;
    private int quantityToBuy;


    public Customer(String name, Gender gender, double cashAtHand, Product product, int quantityToBuy) {
        super(name, gender);
    }
}
