package service.impl;

import entities.Customer;
import entities.Product;
import entities.Staff;
import enums.Role;
import exceptions.ServiceException;
import service.CashierService;
import storerepository.Store;

import java.util.ListIterator;

public class CashierServiceImpl implements CashierService {
    Store store = new Store();


    public String sellProduct(Staff cashier, Customer customer) {
        if (customer == null || cashier == null) throw new ServiceException("customer or cashier cannot be null");
        if (Role.CASHIER.equals(cashier.getRole())) {
            while (!store.getCustomerQueue().isEmpty()) {
                customer = store.getCustomerQueue().poll();
                if (store.getProductsInStore().contains(customer.getProductToBuy())) {
                    while (store.getStoreIterator().hasNext()){
                        if(store.getStoreIterator().next()==customer.getProductToBuy()){
                            customer.setCashAtHand(customer.getCashAtHand()-(customer.getProductToBuy().getUnitPrice()* customer.getQuantityToBuy()));
                            store.getStoreIterator().next().setQuantityOfProductAvailable(store.getStoreIterator().next().getQuantityOfProductAvailable()- customer.getQuantityToBuy());
                            return customer.getName()+ "Your goods have been delivered";
                        }

                        }
                    }else throw new ServiceException("This product is unavailable");

                }
            } else return "This an only be carried out by a cashier";


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
