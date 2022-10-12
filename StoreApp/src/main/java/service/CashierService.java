package service;

import entities.Customer;
import entities.Product;
import storerepository.Store;

public interface CashierService {
     String sellProduct(Customer customer, Product product);
     String dispenseReceipt(Customer customer);

}
