package di;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {

        customers.put("C1001", "Jane Doe");
        customers.put("C1002", "John Smith");
        customers.put("C1003", "Bob Johnson");
    }

    @Override
    public String findCustomerById(String id) {
        return customers.getOrDefault(id, "Customer Not Found");
    }
}
