package service.impl;

import entities.Customer;
import entities.Product;
import entities.Staff;
import enums.Role;
import exceptions.ServiceException;
import service.CashierService;
import storerepository.Store;

import java.math.BigDecimal;
import java.math.MathContext;


public class CashierServiceImpl implements CashierService {
    Store store = new Store();


    public String sellForCustomer(Staff cashier, Customer customer) {
        if (customer == null || cashier == null) throw new ServiceException("customer or cashier cannot be null");
        for (Product itemInCart : customer.getCart()
             ) {
            for (Product productInStore: store.getProductsInStore()
                 ) {
                if ( itemInCart.getNameOfProduct().equals(productInStore.getNameOfProduct())){
                     customer.setCashAtHand(customer.getCashAtHand().subtract(productInStore.getUnitPrice(),new MathContext(2)));
                     productInStore.setQuantityOfProductAvailable(productInStore.getQuantityOfProductAvailable()-itemInCart.getQuantityOfProductAvailable());
            }
            }
        }
        return customer.getName() + " Your order has been processed";
    }
    public String dispenseReceipt(Staff cashier, Customer customer, BigDecimal totalCost) {
        if(customer==null) throw new ServiceException("customer cannot be null");
        if (!Role.CASHIER.equals(cashier.getRole())) return "Only a cashier can carry out this function";
        else if (!store.getCustomerQueue().contains(customer)) {
            return """
             You purchased goods worth %s
             Thanks for your patronage
                    """.formatted(totalCost);
        }
        return "";
    }
}
