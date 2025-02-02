package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.service;

import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.dto.TaxCommissionDto;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Commission;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Tax;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository.CommissionRepository;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository.TaxRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
/**
 * bu servis, distrubed bir cache'de olacak olan yönetim algorithmasını temsil eder.
 * amaç: bu parametleri, db'ye gitmeden her zaman cache'den almak ve cache'i de belirli aralıklarla veya
 * bir event aracılığıyla ( kafka ) yenilemektir.
 * map olarak belirtilen parametre yerine, redis gibi cache db'leri koyulabilir.
 */
public class CacheService {

    private Map<String, TaxCommissionDto> taxCommissionDtoMap;
    private final TaxRepository taxRepository;
    private final CommissionRepository commissionRepository;

    @PostConstruct
    private void init() {
        Map<String, TaxCommissionDto> temp = new HashMap<>();

        List<Tax> taxes = taxRepository.findAll();
        List<Commission> commissions = commissionRepository.findAll();


        Map<String, List<Tax>> taxesByCountry = taxes.stream()
                .collect(Collectors.groupingBy(Tax::getCountryCode));

        Map<String, Commission> commissionsByCountry = commissions.stream()
                .collect(Collectors.toMap(Commission::getCountryCode, c -> c));

        taxesByCountry.forEach((countryCode, countryTaxes) -> {
            Commission commission = commissionsByCountry.get(countryCode);
            TaxCommissionDto dto = TaxCommissionDto.builder()
                    .taxes(countryTaxes)
                    .commission(commission)
                    .build();

            temp.put(countryCode, dto);
        });

        taxCommissionDtoMap = temp;
    }

    public TaxCommissionDto getTaxCommissionByCountry(String countryCode) {
        return taxCommissionDtoMap.get(countryCode);
    }

    @Scheduled(fixedRate = 3600000) // Refresh cache every hour
    public void refreshCache() {
        init();
    }
}
