package service;

import entities.Customer;
import entities.Product;
import entities.Staff;

public interface CashierService {
     String sellProduct(Staff cashier, Customer customer);
     String dispenseReceipt(Staff cashier, Customer customer);

}
