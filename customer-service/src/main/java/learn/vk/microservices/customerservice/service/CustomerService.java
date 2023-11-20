package learn.vk.microservices.customerservice.service;

import learn.vk.microservices.customerservice.entity.Customer;
import learn.vk.microservices.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if(customerOptional.isPresent()){
            Customer customerDb = customerOptional.get();
            customerDb.setId(customer.getId());
        }
        return customer;
    }
}
