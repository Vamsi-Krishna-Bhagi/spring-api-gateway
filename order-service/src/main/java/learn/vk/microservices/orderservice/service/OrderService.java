package learn.vk.microservices.orderservice.service;

import learn.vk.microservices.orderservice.entity.Orders;
import learn.vk.microservices.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public Orders getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Orders updateOrder(Orders orders) {
        Optional<Orders> optionalOrder = orderRepository.findById(orders.getId());
        if (optionalOrder.isPresent()) {
            orders.setId(optionalOrder.get().getId());
            orderRepository.save(orders);
        }
        return orders;
    }

    public Orders createOrder(Orders orders) {
        return orderRepository.save(orders);
    }
}
