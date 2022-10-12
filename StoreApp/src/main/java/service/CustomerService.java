package service;

import entities.Customer;
import entities.Product;

import java.math.BigInteger;

public interface CustomerService {
    String buyProduct(Customer customer, Product product, int noToBeBought);

}
