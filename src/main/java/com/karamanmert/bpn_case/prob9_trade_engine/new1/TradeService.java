package com.karamanmert.bpn_case.prob9_trade_engine.new1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author karamanmert
 */
@Service // interface oluşturup implsinden ilerleyebilirdik kısaltmak için böyle ilerdim.
@RequiredArgsConstructor
public class TradeService {

    private final OrderService orderService;
    private final OrderMatcher orderMatcher;
    private final TradeExecutor tradeExecutor;
    private final ReentrantLock lock = new ReentrantLock();

    @Transactional
    // synchronized
    public synchronized void matchOrders(Order order) {
        final Order incomingOrder = orderService.getOrderByOrderId(order.getId());
        final List<Order> orders = orderService.getAllOrders();

        Optional<Order> existingOrder = orderMatcher.findMatch(incomingOrder, orders);

        if (existingOrder.isPresent()) {
            tradeExecutor.executeTrade(incomingOrder, existingOrder.get());
            updateOrders(existingOrder.get(), incomingOrder);
        }

        /*
        for (Order existing : orderService.getAllOrders()) {
            if (existing.isMatch(incomingOrder)) {
                executeTrade(existing, incomingOrder);
                existing.setStatus(OrderStatus.FILLED);
                incomingOrder.setStatus(OrderStatus.FILLED);
                orderService.save(existing);
                orderService.save(existing);
                break;
            }
        }*/
    }

    @Transactional
    // ReentrantLock
    public void matchOrdersv2(Order order) {
        lock.lock();
        try {
            final Order incomingOrder = orderService.getOrderByOrderId(order.getId());
            final List<Order> orders = orderService.getAllOrders();

            Optional<Order> existingOrder = orderMatcher.findMatch(incomingOrder, orders);

            if (existingOrder.isPresent()) {
                tradeExecutor.executeTrade(incomingOrder, existingOrder.get());
                updateOrders(existingOrder.get(), incomingOrder);
            }
        } finally {
            lock.unlock();
        }
    }

    private void updateOrders(Order existingOrder, Order incomingOrder) {
        existingOrder.setStatus(OrderStatus.FILLED);
        incomingOrder.setStatus(OrderStatus.FILLED);
        orderService.save(incomingOrder);
        orderService.save(existingOrder);
    }
}
