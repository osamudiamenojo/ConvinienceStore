package entities;
import lombok.Data;

@Data
public class Customer extends Person {
    private double CashAtHand;
    private Product productToBuy;
    private int quantityToBuy;


}
