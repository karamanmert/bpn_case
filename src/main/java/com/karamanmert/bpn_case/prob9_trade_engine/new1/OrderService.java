package com.karamanmert.bpn_case.prob9_trade_engine.new1;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author karamanmert
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderByOrderId(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order not found")
        );
    }
}
