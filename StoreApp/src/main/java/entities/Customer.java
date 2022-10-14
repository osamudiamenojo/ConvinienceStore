package entities;
import enums.Gender;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

@Getter
@Setter
@ToString
@EqualsAndHashCode


public class Customer extends Person {

    private BigDecimal CashAtHand;
    private ArrayList<Product> cart = new ArrayList<>();



    public Customer(String name, Gender gender, BigDecimal cashAtHand, Product product, int quantityToBuy) {
        super(name, gender);
    }
}
