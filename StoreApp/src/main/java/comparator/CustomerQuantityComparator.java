package comparator;

import entities.Customer;

import java.util.Comparator;

public class CustomerQuantityComparator implements Comparator<Customer> {

    public int compare(Customer customer1, Customer customer2) {
        return Integer.compare(customer2.getQuantityToBuy(), customer1.getQuantityToBuy());
    }

}
