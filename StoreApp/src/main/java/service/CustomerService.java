package service;

import entities.Customer;
import entities.Product;

public interface CustomerService {
    String buyProduct(Customer customer, Product product, int quantityNeeded);
    void addToCart(Customer customer, Product product);

}
