package entities;

import enums.Category;
import lombok.Data;

@Data

public class Product {
    private String nameOfProduct;
    private String productID;
    private double unitPrice;
    private int quantityOfProductAvailable;
    private Category category;

}
