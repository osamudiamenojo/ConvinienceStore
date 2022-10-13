package service.impl;

import entities.Customer;
import entities.Product;
import exceptions.ServiceException;
import service.CustomerService;
import storerepository.Store;

public class CustomerServiceImpl implements CustomerService {
    Store store = new Store();
    @Override
    public String buyProduct(Customer customer, Product product) {
        if(customer==null || product==null) throw new ServiceException("customer or product cannot be null");
        product.setQuantityOfProductAvailable(customer.getQuantityToBuy());
        customer.setProductToBuy(product);
        store.getCustomerQueue().offer(customer);
        return "Your order is processing";
    }
}
