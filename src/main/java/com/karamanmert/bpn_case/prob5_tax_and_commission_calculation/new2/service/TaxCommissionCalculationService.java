package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.service;

import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.dto.TaxCommissionDto;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Commission;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Tax;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository.CommissionRepository;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository.TaxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
public class TaxCommissionCalculationService {

    private final CacheService cacheService;

    public BigDecimal commissionCalculation(String countryCode, BigDecimal amount) {
        Commission commission = cacheService.getTaxCommissionByCountry(countryCode).getCommission();
        return calculateCommission(commission, amount);
    }

    public BigDecimal taxCalculation(String countryCode, BigDecimal amount) {
        List<Tax> taxes = cacheService.getTaxCommissionByCountry(countryCode).getTaxes();
        return calculateTax(taxes, amount);
    }

    // burada aralıklar çekilirken bir bus. logic belirlenip, db tarafında da aralıkların o şekilde eklemesi gerekebilir.
    private BigDecimal calculateTax(List<Tax> taxes, BigDecimal amount) {
        for (Tax tax : taxes) {
            if (tax.getMinAmount() == null || tax.getMinAmount().compareTo(amount) <= 0) {
                if (tax.getMaxAmount() == null || tax.getMaxAmount().compareTo(amount) > 0) {
                    return tax.getRate().multiply(amount);
                }
            }
        }
        throw new RuntimeException("tax rate not found!");
    }

    private BigDecimal calculateCommission(Commission commission, BigDecimal amount) {
        return amount.multiply(commission.getRate());
    }
}
