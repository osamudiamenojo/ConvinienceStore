package service.impl;

import entities.Customer;
import entities.Product;
import enums.Category;
import exceptions.ServiceException;
import service.CustomerService;
import storerepository.Store;

import java.math.BigInteger;

public class CustomerServiceImpl implements CustomerService {

    public CashierServiceImpl getCashierService() {
        return cashierService;
    }
    private CashierServiceImpl cashierService = new CashierServiceImpl();
    //private Customer customer = new Customer();
    private Store store = new Store();


    public String buyProduct(Customer customer, Product product, int noToBeBought) {
        if (customer == null || product == null) {
            throw new NullPointerException("product or customer cannot be null");
        }
          addToCart(customer, product);
        product.setCountOfProduct(noToBeBought);
        store.getCustomersQueue().add(customer);
        return "Please wait in line";
    }

    public void addToCart(Customer customer, Product product) {
        if(customer==null || product==null) throw new ServiceException("Customer or Product cannot be null");
        if(!customer.getCart().add(product))throw new ServiceException("Product not added");
    }

    public int getCountOfProductsInCart(Customer customer){
        int sumOfCounts=0;
        for (Product product:
                customer.getCart()) {
            sumOfCounts+=product.getCountOfProduct();
        }
        return sumOfCounts;
    }
    public BigInteger getTotalCostPerCustomer(Customer customer){
        BigInteger totalCost = BigInteger.valueOf(0);
        for (Product product:
                customer.getCart()){
            totalCost = totalCost.add(product.getPrice());
        }
        return totalCost;
    }
}
