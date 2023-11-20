package learn.vk.microservices.orderservice.controller;

import learn.vk.microservices.orderservice.entity.Orders;
import learn.vk.microservices.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Orders getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
    @PostMapping("/")
    public Orders createOrder(@RequestBody Orders orders) {
        return orderService.createOrder(orders);
    }
    @PutMapping("/{id}")
    public Orders updateOrder(@RequestBody Orders orders) {
        return orderService.updateOrder(orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
