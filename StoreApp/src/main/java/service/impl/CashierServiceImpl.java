package service.impl;

import entities.Customer;
import entities.Product;
import entities.Receipt;
import exceptions.ServiceException;
import service.CashierService;
import service.CustomerService;
import storerepository.Store;
import java.util.Iterator;

public class CashierServiceImpl implements CashierService {

    private Store store = new Store();
    private CustomerService customerService = new CustomerServiceImpl();

    public String dispenseReceipt(Customer customer) {
        if (customer == null) throw new ServiceException("customer cannot be null");

        Receipt receipt = new Receipt(customer.getName(), customerService.getTotalCostPerCustomer(customer));
        return receipt.toString();

    }

@Override
    public String sellProduct(Customer customer, Product product) {
    if (customer == null || product == null) {
        throw new ServiceException("customer or product cannot be null");
    }
    while (!store.getCustomersQueue().isEmpty()) {
                customer = store.getCustomersQueue().poll();
        Iterator<Product> cartIterator = customer.getCart().iterator();
                if(cartIterator.hasNext() && store.getProductsInStore().contains(cartIterator.next())){
                    for(Product productInStore : store.getProductsInStore()){
                        if(customer.getCashAtHand().compareTo(cartIterator.next().getPrice())<=0) {
                            throw new ServiceException("insufficient funds for this product");
                        } else if (productInStore.equals(cartIterator.next())) {
                            customer.setCashAtHand(customer.getCashAtHand().subtract(productInStore.getPrice()));
                            productInStore.setCountOfProduct(productInStore.getCountOfProduct()-cartIterator.next().getCountOfProduct());
                            return "product Sold";
                        }
                    }

                }
            }
    return "Queue is empty";
}
    }
