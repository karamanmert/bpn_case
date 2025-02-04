package com.karamanmert.bpn_case.prob9_trade_engine.new1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderMatcher {

    // TODO: Order bir entity olduğu için içerisine business logic yazmak istemedim. ayırdır.
    public boolean isMatch(Order buyOrder, Order sellOrder) {
        return buyOrder.getPrice().compareTo(sellOrder.getPrice()) == 0;
    }

    public Optional<Order> findMatch(Order incomingOrder, List<Order> allOrders) {
        for (Order existing : allOrders) {
            if (isMatch(existing, incomingOrder)) {
                return Optional.of(existing);
            }
        }
        return Optional.empty();
    }
}