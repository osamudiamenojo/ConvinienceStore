import entities.Applicant;
import entities.Customer;
import entities.Product;
import entities.Staff;
import enums.Category;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import service.CashierService;
import service.ManagerService;
import service.impl.CashierServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ManagerServiceImpl;
import service.impl.ProductServiceImpl;
import storerepository.Store;

import java.math.BigInteger;
import java.util.UUID;

public class Main {
    private final static ManagerService managerService = new ManagerServiceImpl();
    private final static CashierService cashierService = new CashierServiceImpl();
    private final static CustomerServiceImpl customerService = new CustomerServiceImpl();

    private final static Store store = new Store();
    private final static ProductServiceImpl productService = new ProductServiceImpl();



    public static void main(String[] args) {
        Applicant applicant1 = new Applicant("Dotun", Gender.MALE, Qualification.BSC);
        Customer customer1 = new Customer("Victor", Gender.MALE, BigInteger.valueOf(5000));
        Customer customer2 = new Customer("Uyi", Gender.MALE, BigInteger.valueOf(10000));
        Customer customer3 = new Customer("Divine", Gender.FEMALE, BigInteger.valueOf(12000));
        Customer customer4 = new Customer("Prscilla", Gender.FEMALE, BigInteger.valueOf(15000));

        Product product1 = new Product("milk", BigInteger.valueOf(220),
                70, Category.BEVERAGES);
        Product product2 = new Product("milk", BigInteger.valueOf(220),89
                ,Category.BEVERAGES);
        Product product3 = new Product("milk", BigInteger.valueOf(220),
                60, Category.BEVERAGES);
        Product product4 = new Product("milk",BigInteger.valueOf(220),
                90, Category.BEVERAGES);
        Product product5 = new Product("milk", BigInteger.valueOf(220),
                60, Category.BEVERAGES);
        Staff manager = new Staff("Dele", Gender.MALE, UUID.randomUUID().toString(),
                Role.MANAGER, Qualification.MSC);
        store.getProductsInStore().add(product1);
        store.getProductsInStore().add(product2);
        store.getProductsInStore().add(product3);
        store.getProductsInStore().add(product4);
        store.getProductsInStore().add(product5);


        applicant1.apply();
        String hireCashierResult = managerService.hireACashier(manager, applicant1);
        System.out.println(hireCashierResult);


        customerService.buyProduct(customer4,product1, 5 );
        customerService.buyProduct(customer4,product3, 9 );
        customerService.buyProduct(customer3, product5,3);
        customerService.buyProduct(customer2, product5, 3);

        System.out.println(store.getCustomersQueue());

        String sellResult = cashierService.sellProduct(customer1);
        System.out.println(sellResult);


        String dispenseReceiptResult = cashierService.dispenseReceipt(customer1);
        System.out.println(dispenseReceiptResult);


    }
}
