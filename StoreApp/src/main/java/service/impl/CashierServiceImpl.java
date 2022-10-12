package service.impl;

import entities.Customer;
import entities.Product;
import entities.Receipt;
import exceptions.ServiceException;
import service.CashierService;
import service.CustomerService;
import storerepository.Store;

import java.math.BigInteger;

public class CashierServiceImpl implements CashierService {

    private Store store = new Store();
    private CustomerService customerService = new CustomerServiceImpl();

    public String dispenseReceipt(Customer customer) {
        if (customer == null) throw new ServiceException("customer cannot be null");

        Receipt receipt = new Receipt(customer.getName(),
                (customer.getProductToBuy().getPrice().multiply(BigInteger.valueOf(customer.getProductToBuy().getCountOfProduct()))));
        return receipt.toString();

    }

    @Override
    public String sellProduct(Customer customer) {
        if (customer == null) {
            throw new ServiceException("customer or product cannot be null");
        }
        while (!store.getCustomersQueue().isEmpty()) {
            customer = store.getCustomersQueue().poll();
            if (store.getProductsInStore().contains(customer.getProductToBuy())) {
                for (Product productInStore : store.getProductsInStore()) {
                    if (productInStore.equals(customer.getProductToBuy())) {
                        if (customer.getCashAtHand().compareTo(productInStore.getPrice()) <= 0) {
                            throw new ServiceException("insufficient funds for this product");
                        } else {
                            customer.setCashAtHand(customer.getCashAtHand().subtract(customer.getProductToBuy().getPrice().multiply(BigInteger.valueOf(customer.getProductToBuy().getCountOfProduct()))));
                            productInStore.setCountOfProduct(productInStore.getCountOfProduct() - customer.getProductToBuy().getCountOfProduct());
                            return productInStore.getNameOfProduct() + "has been delivered to " + customer.getName();
                        }
                    }
                }
            } else {
                throw new ServiceException("unavailable product");
            }
        }
        return "All customers have been attended to";
    }
}
