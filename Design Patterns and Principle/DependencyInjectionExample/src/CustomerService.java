package di;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomerDetails(String id) {
        String customerName = repository.findCustomerById(id);
        System.out.println("Customer Profile Request (ID: " + id + ") -> Name: " + customerName);
    }
}
