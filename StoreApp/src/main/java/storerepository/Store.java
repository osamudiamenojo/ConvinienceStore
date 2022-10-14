package storerepository;

import comparator.CustomerQuantityComparator;
import entities.Customer;
import entities.Product;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
@Getter


public class Store {
    private List<Product> productsInStore = new ArrayList();
    private PriorityQueue<Customer> customerQueue = new PriorityQueue<>(new CustomerQuantityComparator());
    private ListIterator<Product> storeIterator = this.getProductsInStore().listIterator();

}
