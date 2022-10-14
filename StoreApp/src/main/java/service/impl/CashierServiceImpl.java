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
    private ListIterator<Product> storeIterator = store.getProductsInStore().listIterator();

    public String sellProduct(Staff cashier, Customer customer) {
        if (customer == null || cashier == null) throw new ServiceException("customer or cashier cannot be null");
        if (Role.CASHIER.equals(cashier.getRole())) {
            while (!store.getCustomerQueue().isEmpty()) {
                customer = store.getCustomerQueue().poll();
                if (store.getProductsInStore().contains(customer.getProductToBuy())) {
                    while (storeIterator.hasNext()){
                        if(storeIterator.next()==customer.getProductToBuy()){
                            customer.setCashAtHand(customer.getCashAtHand()-(customer.getProductToBuy().getUnitPrice()* customer.getQuantityToBuy()));
                            storeIterator.next().setQuantityOfProductAvailable(storeIterator.next().getQuantityOfProductAvailable()- customer.getQuantityToBuy());
                            return customer.getName()+ "Your goods have been selivered";
                        }

                        }
                    }

                }
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
