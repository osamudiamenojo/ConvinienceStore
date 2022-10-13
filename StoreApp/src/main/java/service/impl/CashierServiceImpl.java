package service.impl;

import entities.Customer;
import entities.Product;
import entities.Staff;
import exceptions.ServiceException;
import service.CashierService;
import storerepository.Store;

public class CashierServiceImpl implements CashierService {
    Store store = new Store();
    public String sellProduct(Staff cashier, Customer customer) {
        if (customer == null || cashier == null)throw new ServiceException("customer or cashier cannot be null");
        return "Queue is empty";
    }

    public String dispenseReceipt(Staff cashier, Customer customer) {
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
