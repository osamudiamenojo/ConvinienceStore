package service.impl;

import entities.Customer;
import entities.Product;
import entities.Staff;
import enums.Role;
import exceptions.ServiceException;
import service.CashierService;
import storerepository.Store;

public class CashierServiceImpl implements CashierService {
    Store store = new Store();
    public String sellProduct(Staff cashier, Customer customer) {
        if (customer == null || cashier == null)throw new ServiceException("customer or cashier cannot be null");
        if(Role.CASHIER.equals(cashier.getRole())) {
            customer = store.getCustomerQueue().poll();
            if(store.getProductsInStore().contains(customer.getProductToBuy())) {
                for (Product productAvailable : store.getProductsInStore()
                ) {

                }
            }else {
                return "Product unavailable";
            }
        } else {
            return "You need to be a cashier to sell";
        }


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
