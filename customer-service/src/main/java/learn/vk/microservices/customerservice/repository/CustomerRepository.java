package learn.vk.microservices.customerservice.repository;

import learn.vk.microservices.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
