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
import storerepository.Store;

import java.util.UUID;

public class StoreApp {
    private final static CashierServiceImpl cashierService = new CashierServiceImpl();
    private final static CustomerServiceImpl customerService= new CustomerServiceImpl();
    private final static Store store =new Store();
    public static void main(String[] args) {


        Applicant applicant1 = new Applicant("Josephine", Gender.FEMALE, Qualification.BSC);

        Staff manager = new Staff("Kolade,", Gender.MALE, UUID.randomUUID().toString(), Role.MANAGER, Qualification.MSC);
        Staff cashier = new Staff("Elijah", Gender.FEMALE, UUID.randomUUID().toString(), Role.CASHIER, Qualification.BSC);

        Product product1= new Product("milk", "P11", 34.00, 390, Category.BEVERAGES);
        Product product2= new Product("soap", "P12", 50.00, 350, Category.HYGIENE);
        Product product3= new Product("phone charger", "P13", 800.00, 100, Category.HYGIENE);


        Customer customer = new Customer("Adedotun", Gender.MALE, 200005.00, product1, 45);

        System.out.println(applicant1.apply());

    }


}
