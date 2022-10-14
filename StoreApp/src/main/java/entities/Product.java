package entities;

import enums.Category;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private String nameOfProduct;
    private String productID;
    private BigDecimal unitPrice;
    private int quantityOfProductAvailable;
    private Category category;



}
