package com.karamanmert.bpn_case.prob6_payment_service.new1;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class LiveExchangeRateService implements ExchangeRateService {

    private final ExchangeRateConfig config;
    private final RestClient restClient;

    public LiveExchangeRateService(ExchangeRateConfig config,
                                   RestClient.Builder restClientBuilder) {
        this.config = config;
        this.restClient = restClientBuilder
                .baseUrl(config.getBaseUrl())
                .build();
    }

    @Override
    public BigDecimal getRate(Currency from, Currency to) {
        ExchangeRateResponse response = fetchExchangeRate(from, to);
        return response.getRates().get(to.name());
    }

    // todo: eğer istek attığımız yerden hata alırsak circuit breaker tarzı patternlar kullabiliriz.
    private ExchangeRateResponse fetchExchangeRate(Currency from, Currency to) {
        String uri = getUri(from, to);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatusCode::isError, (req, res) -> {
                    throw new RateFetchException("API error: " + res.getStatusText());
                })
                .body(ExchangeRateResponse.class);
    }

    private String getUri(Currency from, Currency to) {
        return UriComponentsBuilder.fromPath("/latest")
                .queryParam("base", from.name())
                .queryParam("symbols", to.name())
                .toUriString();
    }
}