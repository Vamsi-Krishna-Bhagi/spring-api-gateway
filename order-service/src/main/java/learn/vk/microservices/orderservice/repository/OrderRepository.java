package learn.vk.microservices.orderservice.repository;

import learn.vk.microservices.orderservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
