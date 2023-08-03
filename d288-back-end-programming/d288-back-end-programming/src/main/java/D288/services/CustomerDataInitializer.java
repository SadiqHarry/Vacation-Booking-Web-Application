package D288.services;

import D288.dao.CustomerRepository;
import D288.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataInitializer {
    private final CustomerRepository customerRepository;

    public CustomerDataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void initializeSampleCustomers() {
        // Create and save five sample customers
        Customer customer1 = createSampleCustomer("John", "Doe", "123 Main Street", "12345", "555-123-4567");
        Customer customer2 = createSampleCustomer("Jane", "Smith", "456 Elm Avenue", "54321", "555-987-6543");
        Customer customer3 = createSampleCustomer("Michael", "Johnson", "789 Oak Road", "67890", "555-567-8901");
        Customer customer4 = createSampleCustomer("Emily", "Williams", "321 Pine Lane", "98765", "555-234-5678");
        Customer customer5 = createSampleCustomer("David", "Brown", "234 Cedar Street", "54321", "555-876-5432");

        // Save customers only if they do not already exist in the database
        saveCustomerIfNotExists(customer1);
        saveCustomerIfNotExists(customer2);
        saveCustomerIfNotExists(customer3);
        saveCustomerIfNotExists(customer4);
        saveCustomerIfNotExists(customer5);
    }

    private Customer createSampleCustomer(String firstName, String lastName, String address, String postalCode, String phone) {
        Customer customer = new Customer();
        customer.setId(customer.getId());
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPostal_code(postalCode);
        customer.setPhone(phone);
        return customer;
    }

    private void saveCustomerIfNotExists(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByPhone(customer.getPhone());
        if (existingCustomer.isEmpty()) {
            customerRepository.save(customer);
        }
    }
}
