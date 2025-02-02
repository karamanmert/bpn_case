package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository;

import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author karamanmert
 */
@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {
    Commission findByCountryCode(String countryCode);
}
