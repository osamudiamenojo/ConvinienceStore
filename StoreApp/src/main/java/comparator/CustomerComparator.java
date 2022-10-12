package comparator;

import entities.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {
    public int compare(Customer customer1, Customer customer2) {
        CustomerService customerService = new CustomerServiceImpl();
        return customerService.getCountOfProductsInCart(customer1) - customerService.getCountOfProductsInCart(customer2);
    }
}
