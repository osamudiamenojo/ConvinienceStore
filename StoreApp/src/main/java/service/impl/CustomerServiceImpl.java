package service.impl;

import entities.Customer;
import entities.Product;
import enums.Category;
import exceptions.ServiceException;
import service.CustomerService;
import storerepository.Store;

import java.math.BigInteger;

public class CustomerServiceImpl implements CustomerService {

   // public CashierServiceImpl getCashierService() {
     //   return cashierService;
   // }
    //private CashierServiceImpl cashierService = new CashierServiceImpl();
    //private Customer customer = new Customer();
    private Store store = new Store();
    public String buyProduct(Customer customer, Product product, int noToBeBought) {
        if (customer == null || product == null) {
            throw new NullPointerException("product or customer cannot be null");
        }
        product.setCountOfProduct(noToBeBought);
        store.getCustomersQueue().offer(customer);
        return "Your order is processing";
    }

}
