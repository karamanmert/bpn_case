package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.dto;

import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Commission;
import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Tax;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author karamanmert
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxCommissionDto {
    private List<Tax> taxes;
    private Commission commission;
}
