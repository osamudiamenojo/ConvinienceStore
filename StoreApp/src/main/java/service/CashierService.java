package service;

import entities.Customer;
import entities.Product;
import entities.Staff;

import java.math.BigDecimal;

public interface CashierService {
     String sellForCustomer(Staff cashier, Customer customer);
     String dispenseReceipt(Staff cashier, Customer customer, BigDecimal totalCost);

}
