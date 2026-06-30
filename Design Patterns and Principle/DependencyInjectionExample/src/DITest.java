package di;

public class DITest {
    public static void main(String[] args) {
        System.out.println("=== Testing Dependency Injection ===");

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.showCustomerDetails("C1001");
        service.showCustomerDetails("C1002");
        service.showCustomerDetails("C9999");
    }
}
