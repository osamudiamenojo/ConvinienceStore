package storerepository;

import entities.Customer;
import entities.Product;
import comparator.CustomerComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Store {
    private  List<Product> productsInStore = new ArrayList();



    private PriorityQueue<Customer> customersQueue = new PriorityQueue( new CustomerComparator());

    public List<Product> getProductsInStore() {
        return productsInStore;
    }

    public PriorityQueue<Customer> getCustomersQueue() {
        return customersQueue;
    }



}
