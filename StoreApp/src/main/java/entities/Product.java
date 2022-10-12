package entities;
import enums.Category;

import java.math.BigInteger;


public class Product {
private String nameOfProduct;
private BigInteger price;
private int countOfProduct;
private Category category;

    public Product(String nameOfProduct, BigInteger price, int countOfProduct, Category category) {
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.countOfProduct = countOfProduct;
        this.category = category;
    }
    public Product() {
    }
    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        countOfProduct = countOfProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
