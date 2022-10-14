import entities.Applicant;
import entities.Customer;
import entities.Product;
import entities.Staff;
import enums.Category;
import enums.Gender;
import enums.Qualification;
import enums.Role;
import service.impl.CashierServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ManagerServiceImpl;
import storerepository.Store;

import java.math.BigDecimal;
import java.util.UUID;

public class StoreApp {
    private final static CashierServiceImpl cashierService = new CashierServiceImpl();
    private final static CustomerServiceImpl customerService= new CustomerServiceImpl();
    private final static ManagerServiceImpl managerService = new ManagerServiceImpl();
    private final static Store store =new Store();
    public static void main(String[] args) {


        Applicant applicant1 = new Applicant("Josephine", Gender.FEMALE, Qualification.BSC);

        Staff manager = new Staff("Kolade,", Gender.MALE, UUID.randomUUID().toString(), Role.MANAGER, Qualification.MSC);
        Staff cashier = new Staff("Elijah", Gender.FEMALE, UUID.randomUUID().toString(), Role.CASHIER, Qualification.BSC);

        Product product1= new Product("milk", "P11", BigDecimal.valueOf(20.00), 390, Category.BEVERAGES);
        Product product2= new Product("soap", "P12", BigDecimal.valueOf(79.00), 350, Category.HYGIENE);
        Product product3= new Product("phone charger", "P13", BigDecimal.valueOf(200.00), 100, Category.HYGIENE);


        Customer customer1 = new Customer("Adedotun", Gender.MALE, BigDecimal.valueOf(20005.00), product1, 45);
        Customer customer2 = new Customer("Samuel", Gender.MALE, BigDecimal.valueOf(20005.00), product2, 40);
        Customer customer3 = new Customer("Zechariah", Gender.MALE, BigDecimal.valueOf(20005.00), product1, 20);
        Customer customer4 = new Customer("Abednego", Gender.MALE, BigDecimal.valueOf(20005.00), product3, 5);
        Customer customer5 = new Customer("Michael", Gender.MALE, BigDecimal.valueOf(20005.00), product1, 45);
        Customer customer6 = new Customer("Emmanuel", Gender.MALE, BigDecimal.valueOf(20005.00), product1, 45);

        System.out.println(applicant1.apply());
        String hireResult = managerService.hire(manager, applicant1);
        System.out.println(hireResult);

        customerService.buyProduct(customer1, product2, 5);
        customerService.buyProduct(customer2, product2, 8);
        customerService.buyProduct(customer3, product2, 9);
        customerService.buyProduct(customer4, product2, 13);
        customerService.buyProduct(customer5, product2, 23);
        String buyingResult = customerService.buyProduct(customer6, product1, 15);
        System.out.println(buyingResult);
        System.out.println(store.getProductsInStore());
        System.out.println(store.getCustomerQueue().size());

    }


}
