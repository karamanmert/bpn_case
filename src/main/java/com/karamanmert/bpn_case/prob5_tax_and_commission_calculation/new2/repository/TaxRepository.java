package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.repository;

import com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author karamanmert
 */
@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
    List<Tax> findByCountryCode(String countryCode);
}
