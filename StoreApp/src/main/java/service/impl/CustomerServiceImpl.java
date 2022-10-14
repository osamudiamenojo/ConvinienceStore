package service.impl;

import entities.Customer;
import entities.Product;
import exceptions.ServiceException;
import lombok.Getter;
import service.CustomerService;
import storerepository.Store;

import java.util.Iterator;

@Getter
public class CustomerServiceImpl implements CustomerService {
    private  Store store = new Store();


    @Override
    public String buyProduct(Customer customer, Product product, int quantityNeeded) {
        if (customer == null || product == null) throw new ServiceException("customer or product cannot be null");
        product.setQuantityOfProductAvailable(quantityNeeded);
        addToCart(customer, product);
        if(!store.getCustomerQueue().contains(customer)) {
            store.getCustomerQueue().offer(customer);
        }
        return "Your order is processing";
    }

    @Override
    public void addToCart(Customer customer, Product product) {
        if (customer == null || product == null) throw new ServiceException("Customer or Product cannot be null");
        if (!customer.getCart().add(product)) throw new ServiceException("Product not added");
        customer.getCart().add(product);
    }
    public int getCountOfProductsInCart(Customer customer){
        int count=0;
        for (Product product: customer.getCart()
             ) {
            count++;
        }
        return count;
    }
}
