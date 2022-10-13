package service.impl;

import entities.Customer;
import entities.Product;
import exceptions.ServiceException;
import service.CashierService;
import storerepository.Store;

public class CashierServiceImpl implements CashierService {
    Store store = new Store();
    public String sellProduct(Customer customer, Product product) {
        if (customer == null)throw new ServiceException("customer cannot be null");
        return "Queue is empty";
    }

    public String dispenseReceipt(Customer customer) {
        if(customer==null) throw new ServiceException("customer cannot be null");
        else if (!store.getCustomerQueue().contains(customer)) {
            return """
              You purchased goods worth %s
             Thanks for your patronage
                    """.formatted(customer.getProductToBuy().getUnitPrice()* customer.getQuantityToBuy());
        }
        return "";
    }
}
