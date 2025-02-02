package com.karamanmert.bpn_case.prob6_payment_service.new1;

import lombok.Getter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author karamanmert
 */
@Configuration
@ConditionalOnProperty(prefix = "exchange.api")
@Getter
public class ExchangeRateConfig {
    private String baseUrl;
}
