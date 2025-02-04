package com.karamanmert.bpn_case.prob9_trade_engine.new1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
public class TradeExecutor {

    public void executeTrade(Order incomingOrder, Order existing) {
        // trade logic
        BigDecimal price = existing.getPrice();
        BigDecimal total = price.multiply(BigDecimal.valueOf(existing.getQuantity()));
        // müşteri hesap güncellemeri, komisyon vb.
    }
}
