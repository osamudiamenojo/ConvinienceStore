package service;

import entities.Customer;
import entities.Product;
import storerepository.Store;

public interface CashierService {
     String sellProduct(Customer customer);
     String dispenseReceipt(Customer customer);

}
