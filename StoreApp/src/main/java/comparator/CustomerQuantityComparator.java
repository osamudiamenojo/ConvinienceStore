package comparator;

import entities.Customer;
import service.CustomerService;
import service.impl.CashierServiceImpl;
import service.impl.CustomerServiceImpl;

import java.util.Comparator;

public class CustomerQuantityComparator implements Comparator<Customer> {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public int compare(Customer customer1, Customer customer2) {
        return Integer.compare(customerService.getCountOfProductsInCart(customer2), customerService.getCountOfProductsInCart(customer1));
    }

}
