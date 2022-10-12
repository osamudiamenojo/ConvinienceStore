package comparator;

import entities.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.util.Comparator;

public class CustomerProductCountComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        if (customer2.getProductToBuy().getCountOfProduct()>customer1.getProductToBuy().getCountOfProduct()){
            return 1;
        }else {
            if(customer2.getProductToBuy().getCountOfProduct()==customer1.getProductToBuy().getCountOfProduct()){
                return 0;
            }
        }
        return -1;
    }
}
